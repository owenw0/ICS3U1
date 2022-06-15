import java.util.*;

public class Main {
    public static char[][] generateBoard() {
        char[][] board = new char[8][8];

        // fill empty squares
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = ' ';
            }
        }

        // fill P1 squares
        for (

                int i = 7; i > 4; i--) {
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

    public static String[] clearLegalMoves(String[] legalMoves) {
        for (int i = 0; i < legalMoves.length; i++) {
            legalMoves[i] = "";
        }
        return legalMoves;
    }

    public static String[] initLegalMoves(char[][] board, int val, String coord, int startCol, int startRow,
            String[] legalMoves) {
        // variable declaration
        String legalMove;
        boolean complete = false;

        // determine legal moves
        try {
            if (board[startRow - val][startCol + val] == ' ') {
                legalMove = "" + (char) (coord.charAt(0) + 1) + (char) (coord.charAt(1) + 1);
                for (int i = 0; i < legalMoves.length && !complete; i++) {
                    if (legalMoves[i] == "") {
                        legalMoves[i] = legalMove;
                        complete = true;
                    }
                }
            }
            complete = false;
            if (board[startRow - val][startCol - val] == ' ') {
                legalMove = "" + (char) (coord.charAt(0) + 1) + (char) (coord.charAt(1) - 1);
                for (int i = 0; i < legalMoves.length && !complete; i++) {
                    if (legalMoves[i] == "") {
                        legalMoves[i] = legalMove;
                        complete = true;
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }

        return legalMoves;
    }

    public static int[] movePrompt(String[] legalMoves, int legalMoveCount) {
        // variable declaration
        boolean validMove = false;
        String move;
        int choice = -1;
        int[] returnVal = new int[3];
        Scanner sc = new Scanner(System.in);

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
        returnVal[0] = coordToIndex(legalMoves[choice - 1])[0];
        returnVal[1] = coordToIndex(legalMoves[choice - 1])[1];
        returnVal[2] = legalMoveCount;

        sc.close();
        return returnVal;
    }

    public static void main(String[] args) {
        // variable declaration
        boolean playing = true, validStart = false;
        int player = 1, val = 1, startRow = 0, startCol = 0, endRow = 0, endCol = 0, legalMoveCount = 0;
        char[][] board;
        char piece;
        String coord;
        String[] legalMoves = new String[8];
        int[] returnVal;
        Scanner sc = new Scanner(System.in);

        // init board
        board = generateBoard();
        drawBoard(board);

        // main loop
        while (playing) {
            // reset variables
            validStart = false;
            legalMoveCount = 0;
            legalMoves = clearLegalMoves(legalMoves);
            // prompt current player to move
            System.out.printf("Player %d's move\n", player);
            if (player == 1) {
                piece = 'x';
            } else {
                piece = 'o';
            }
            // prompt for starting piece location
            while (!validStart) {
                System.out.print("Enter piece coordinate: ");
                coord = sc.nextLine().toLowerCase().replaceAll("\\s+", "");

                // determine if valid coord
                if (coord.length() != 2 || coord.charAt(0) < 97 || coord.charAt(0) > 104 || coord.charAt(1) < 49
                        || coord.charAt(1) > 56) {
                    System.out.println("\nInvalid coordinate.");
                } else {
                    startCol = coordToIndex(coord)[0];
                    startRow = coordToIndex(coord)[1];

                    // determine if there is a piece at given position
                    if (Character.toLowerCase(board[startRow][startCol]) != piece) {
                        System.out.println("\nInvalid piece selected.");
                    } else if (initLegalMoves(board, val, coord, startCol, startRow, legalMoves)[0].equals("")) {
                        System.out.println("\nPiece has no valid moves.");
                    } else {
                        validStart = true;
                    }
                }
            }

            // determine valid move positions
            returnVal = movePrompt(legalMoves, legalMoveCount);
            endCol = returnVal[0];
            endRow = returnVal[1];

            board[startRow][startCol] = ' ';
            board[endRow][endCol] = piece;

            drawBoard(board);

            // switch player
            if (player == 1) {
                player = 2;
                val = -1;
            } else {
                player = 1;
                val = 1;
            }
        }
        sc.close();
    }
}