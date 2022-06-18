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
        String[][] legalCaptures = new String[4][2];
        String legalCapture, legalMove;
        char oppPiece;
        boolean king = false, complete = false;
        int val, startCol = startCoord[0], startRow = startCoord[1];

        // determine piece values
        if (Character.toLowerCase(piece) == 'x') {
            if (piece == 'X') {
                king = true;
            }
            val = 1;
            oppPiece = 'o';
        } else {
            if (piece == 'O') {
                king = true;
            }
            val = -1;
            oppPiece = 'x';
        }

        // determine possible captures
        for (int i = 0; i <= 1; i += 2) {
            try {
                if (Character.toLowerCase(board[startRow - val][startCol + i]) == oppPiece
                        && board[startRow - (val * 2)][startCol + 2 * i] == ' ') {
                    // available jump
                    legalCapture = "" + (char) (coord.charAt(0) + i) + (char) (coord.charAt(1) + val);
                    legalMove = "" + (char) (coord.charAt(0) + i * 2) + (char) (coord.charAt(1) + val * 2);
                    for (int j = 0; j < legalCaptures.length && !complete; j++) {
                        legalCaptures[j][0] = legalCapture;
                        legalCaptures[j][1] = legalMove;
                        complete = true;
                    }
                }
            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }

        return legalCaptures;
    }

    public static String[] initLegalMoves(char[][] board, char piece, String coord, int[] startCoord) {
        // variable declaration
        String[] legalMoves = new String[4];
        String legalMove;
        boolean king = false, complete = false;
        int val, startCol = startCoord[0], startRow = startCoord[1];

        // determine piece values
        if (Character.toLowerCase(piece) == 'x') {
            if (piece == 'X') {
                king = true;
            }
            val = 1;
        } else {
            if (piece == 'O') {
                king = true;
            }
            val = -1;
        }

        // determine possible moves
        try {
            for (int i = -1; i <= 1; i += 2) {
                if (board[startRow - val][startCol + i] == ' ') {
                    // determine coord pos
                    legalMove = "" + (char) (coord.charAt(0) + i) + (char) (coord.charAt(1) + val);
                    for (int j = 0; j < legalMoves.length && !complete; j++) {
                        if (legalMoves[j] == "") {
                            legalMoves[j] = legalMove;
                            complete = true;
                        }
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }

        return legalMoves;
    }

    public static int[] movePrompt(String[] legalMoves) {
        // variable declaration
        boolean validMove = false;
        String move;
        int legalMoveCount = 0, choice = -1;
        int[] coord = new int[2];

        // display possible moves
        System.out.println("\nSelect from valid moves:");
        for (int i = 0; i < legalMoves.length && legalMoves[i] != ""; i++) {
            System.out.printf("%d: %s\n", i + 1, legalMoves[i]);
            legalMoveCount++;
        }

        // prompt for move
        while (!validMove) {
            System.out.print("> ");
            move = sc.nextLine();
            if (move.equals("1") && legalMoveCount >= 1) {
                // first option
                choice = 1;
                validMove = true;
            } else if (move.equals("2") && legalMoveCount >= 2) {
                // second option
                choice = 2;
                validMove = true;
            } else if (move.equals("3") && legalMoveCount >= 3) {
                // third option
                choice = 3;
                validMove = true;
            } else if (move.equals("4") && legalMoveCount >= 4) {
                // fourth option
                choice = 4;
                validMove = true;
            } else {
                System.out.println("Invalid option.");
            }
        }
        coord = coordToIndex(legalMoves[choice - 1]);

        return coord;
    }

    public static void main(String[] args) {
        // variable declaration
        boolean run = true, onePlayer = false, twoPlayer = false;
        int player = 1, startRow = -1, startCol = -1, endRow, endCol, turns = 0;
        char[][] board = new char[8][8];
        char piece = 'x';
        String playerCount, coord;
        String[][] legalCaptures;
        String[] legalMoves;
        int[] startCoord = new int[2], returnVal;

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
                    } else if (initLegalCaptures(board, piece, coord, startCoord)[0][0] == ""
                            && initLegalMoves(board, piece, coord, startCoord)[0].equals("")) {
                        System.out.println("\nPiece has no valid moves.");
                    } else {
                        run = false;
                    }
                }
            } while (run);

            // determine valid move positions
            legalCaptures = initLegalCaptures(board, piece, coord, startCoord);
            legalMoves = initLegalMoves(board, piece, coord, startCoord);
            returnVal = movePrompt(legalMoves);
            endCol = returnVal[0];
            endRow = returnVal[1];

            board[startRow][startCol] = ' ';
            board[endRow][endCol] = piece;
            drawBoard(board);
            turns++;

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