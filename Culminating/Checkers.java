import java.util.*;

public class Checkers {
    // scanner variable
    public static Scanner sc = new Scanner(System.in);

    public static char[][] generateBoard() {
        char[][] board = new char[8][8];

        // fill empty squares
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = ' ';
            }
        }

        // fill P1 squares
        for (int i = 7; i > 4; i--) {
            if (i % 2 == 0) {
                for (int j = 1; j < 8; j += 2)
                    board[i][j] = 'x';
            } else {
                for (int j = 0; j < 8; j += 2)
                    board[i][j] = 'x';
            }
        }

        // fill P2 squares
        for (int i = 0; i < 3; i++) {
            if (i % 2 == 0) {
                for (int j = 1; j < 8; j += 2)
                    board[i][j] = 'o';
            } else {
                for (int j = 0; j < 8; j += 2)
                    board[i][j] = 'o';
            }
        }
        return board;
    }

    public static void drawBoard(char[][] board) {
        // print board borders
        System.out.print("\n  ");
        for (int i = 0; i < 8; i++) {
            System.out.print("+---");
        }
        System.out.print("+\n");

        // print board content
        for (int i = 0; i < 8; i++) {
            // print board y coordinate
            System.out.print(Math.abs(8 - i) + " ");
            // print piece on each square
            for (int j = 0; j < 8; j++) {
                System.out.print("| " + board[i][j] + " ");
            }
            // print board borders
            System.out.print("|\n  ");
            for (int k = 0; k < 8; k++) {
                System.out.print("+---");
            }
            System.out.print("+\n");
        }

        System.out.print(" ");
        // print board x coordinates
        for (int i = 97; i <= 104; i++) {
            System.out.print("   " + (char) i);
        }
        System.out.println("\n");
    }

    public static int[] coordToIndex(String coord) {
        // variable declaration
        int[] indexNums = new int[2]; // [col, row]

        // convert coordinate system to array index system
        indexNums[0] = (int) coord.charAt(0) - 97; // column
        indexNums[1] = Math.abs(((int) coord.charAt(1) - 49) - 7); // row

        return indexNums;
    }

    public static String[][] initLegalCaptures(char[][] board, char piece, String coord, int[] startCoord) {
        // variable declaration
        String[][] legalCaptures = new String[2][2];
        String legalCapture, legalMove;
        char oppPiece;
        boolean complete = false;
        int val, val1 = 1, startCol = startCoord[0], startRow = startCoord[1];

        // determine piece values
        if (Character.toLowerCase(piece) == 'x') {
            if (piece == 'X') {
                legalCaptures = new String[4][2];
                val1++;
            }
            val = 1;
            oppPiece = 'o';
        } else {
            if (piece == 'O') {
                legalCaptures = new String[4][2];
                val1++;
            }
            val = -1;
            oppPiece = 'x';
        }

        // determine possible captures
        for (int i = 0; i < val1; i++) {
            // check right and left of piece
            for (int j = -1; j <= 1; j += 2) {
                try {
                    if (Character.toLowerCase(board[startRow - val][startCol + j]) == oppPiece
                            && board[startRow - val * 2][startCol + j * 2] == ' ') {
                        // available jump
                        legalCapture = "" + (char) (coord.charAt(0) + j) + (char) (coord.charAt(1) + val);
                        legalMove = "" + (char) (coord.charAt(0) + j * 2) + (char) (coord.charAt(1) + val * 2);
                        for (int k = 0; k < legalCaptures.length && !complete; k++) {
                            if (legalCaptures[k][0] == null) {
                                legalCaptures[k][0] = legalCapture;
                                legalCaptures[k][1] = legalMove;
                                complete = true;
                            }
                        }
                        complete = false;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                }
            }
            val = (Math.abs(val) + 1) * val;
        }
        return legalCaptures;
    }

    public static String[] initLegalMoves(char[][] board, char piece, String coord, int[] startCoord) {
        // variable declaration
        String[] legalMoves = new String[2];
        String legalMove;
        boolean complete = false;
        int val, val1 = 1, startCol = startCoord[0], startRow = startCoord[1];

        // determine piece values
        if (Character.toLowerCase(piece) == 'x') {
            if (piece == 'X') {
                legalMoves = new String[4];
                val1++;
            }
            val = 1;
        } else {
            if (piece == 'O') {
                legalMoves = new String[4];
                val1++;
            }
            val = -1;
        }

        for (int i = 0; i < val1; i++) {
            for (int j = -1; j <= 1; j += 2) {
                try {
                    if (board[startRow - val][startCol + j] == ' ') {
                        // determine coord pos
                        legalMove = "" + (char) (coord.charAt(0) + j) + (char) (coord.charAt(1) + val);
                        for (int k = 0; k < legalMoves.length && !complete; k++) {
                            if (legalMoves[k] == null) {
                                legalMoves[k] = legalMove;
                                complete = true;
                            }
                        }
                        complete = false;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                }
            }
            val = (Math.abs(val) + 1) * val;
        }
        return legalMoves;
    }

    public static int[] movePrompt(String[][] legalCaptures, String[] legalMoves) {
        // variable declaration
        boolean validMove = false;
        String move;
        int counter = 1, legalCaptureCount = 0, legalMoveCount = 0, choice = -1;

        System.out.println("\nSelect from valid moves:");

        // display possible captures
        for (int i = 0; i < legalCaptures.length && legalCaptures[i][0] != null; i++) {
            System.out.printf("%d: x%s\n", counter, legalCaptures[i][0]);
            legalCaptureCount++;
            counter++;
        }

        // display possible moves
        for (int i = 0; i < legalMoves.length && legalMoves[i] != null; i++) {
            System.out.printf("%d: %s\n", counter, legalMoves[i]);
            legalMoveCount++;
            counter++;
        }

        // prompt for move
        while (!validMove) {
            System.out.print("> ");
            move = sc.nextLine();

            for (int i = 1; i <= 4 && !validMove; i++) {
                if (move.equals(Integer.toString(i)) && legalMoveCount >= i) {
                    choice = i;
                    validMove = true;
                }
            }
            if (!validMove) {
                System.out.println("Invalid option.");
            }
        }

        // chose to capture
        return coordToIndex(legalMoves[choice - 1]);
    }

    public static void main(String[] args) {
        // variable declaration
        boolean run = true, onePlayer = false, twoPlayer = false;
        int player = 1, startRow = -1, startCol = -1, endRow, endCol, turns = 0;
        char[][] board = new char[8][8];
        char piece = 'x';
        String playerCount, coord;
        int[] startCoord = new int[2], returnCoord;

        // prompt for player count
        do {
            System.out.print("How many players are there? (1/2)\n> ");
            playerCount = sc.nextLine().replaceAll("\\s+", "");

            switch (playerCount) {
                case "1":
                    onePlayer = true;
                    run = false;
                    break;

                case "2":
                    twoPlayer = true;
                    run = false;

                    // init board
                    board = generateBoard();
                    drawBoard(board);
                    break;

                default:
                    System.out.println("Invalid option.\n");
            }
        } while (run);

        // vs AI
        while (onePlayer) {
            System.out.println("\nAI is not available.");
            onePlayer = false;
        }

        // pvp
        while (twoPlayer) {
            // reset variables
            run = true;

            // prompt current player to move
            System.out.printf("Player %d's move\n", player);

            // prompt for starting piece location
            do {
                System.out.print("Enter piece coordinate: ");
                coord = sc.nextLine().toLowerCase().replaceAll("\\s+", "");

                // determine if valid coord
                if (coord.length() != 2 || coord.charAt(0) < 97 || coord.charAt(0) > 104 || coord.charAt(1) < 49
                        || coord.charAt(1) > 56) {
                    System.out.println("\nInvalid coordinate.");
                } else {
                    startCoord = coordToIndex(coord);
                    startCol = startCoord[0];
                    startRow = startCoord[1];

                    // determine if there is a piece at given position
                    if (Character.toLowerCase(board[startRow][startCol]) != piece) {
                        System.out.println("\nInvalid piece selected.");
                    } else if (initLegalCaptures(board, piece, coord, startCoord)[0][0] == null
                            && initLegalMoves(board, piece, coord, startCoord)[0] == null) {
                        System.out.println("\nPiece has no valid moves.");
                    } else {
                        run = false;
                    }
                }
            } while (run);

            // determine valid move positions
            returnCoord = movePrompt(initLegalCaptures(board, piece, coord, startCoord),
                    initLegalMoves(board, piece, coord, startCoord));
            endCol = returnCoord[0];
            endRow = returnCoord[1];

            board[startRow][startCol] = ' ';
            board[endRow][endCol] = piece;
            // determine king status
            if (endRow == 7 || endRow == 0) {
                board[endRow][endCol] = Character.toUpperCase(piece);
            }
            turns++;
            drawBoard(board);

            // switch player
            if (player == 1) {
                player = 2;
                piece = 'o';
            } else {
                player = 1;
                piece = 'x';
            }
        }
        System.out.printf("Game lasted %d turns\n", turns);
    }
}