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

    public static String[] initLegalMoves(String[] legalMoves) {
        for (int i = 0; i < legalMoves.length; i++) {
            legalMoves[i] = "";
        }
        return legalMoves;
    }

    public static String[] addLegalMove(String[] legalMoves, String legalMove) {
        // variable declaration
        boolean complete = false;
        for (int i = 0; i < legalMoves.length && !complete; i++) {
            if (legalMoves[i] == "") {
                legalMoves[i] = legalMove;
                complete = true;
            }
        }
        return legalMoves;
    }

    public static int[] coordToIndex(String coord) {
        // variable declaration
        int[] indexNums = new int[2];

        // convert coordinate system to array index system
        indexNums[0] = (int) coord.charAt(0) - 97; // column
        indexNums[1] = Math.abs(((int) coord.charAt(1) - 49) - 7);

        return indexNums;
    }

    public static void main(String[] args) {
        // variable declaration
        boolean playing = true;
        int player = 1;
        char[][] board;
        char piece;
        String coord = "";
        int startRow = -1, startCol = -1, endRow = -1, endCol = -1;
        boolean validCoord = false, validStart = false;
        String[] legalMoves = new String[8];
        String legalMove;
        Scanner sc = new Scanner(System.in);

        // init board and legal move array
        legalMoves = initLegalMoves(legalMoves);
        board = generateBoard();
        drawBoard(board);

        // main loop
        while (playing) {
            // reset variables
            validCoord = false;
            validStart = false;
            // prompt current player to move
            System.out.printf("Player %d's move\n", player);
            if (player == 1) {
                piece = 'x';
            } else {
                piece = 'o';
            }
            // prompt for starting piece location
            while (!validCoord) {
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
                        } else {
                            validStart = true;
                        }
                    }
                }

                // determine valid move positions
                if (player == 1) {
                    // x move
                    if (piece == 'x') {
                        // regular piece
                        try {
                            if (board[startRow - 1][startCol + 1] == ' ') {
                                legalMove = "" + (char) (coord.charAt(0) + 1) + (char) (coord.charAt(1) + 1);
                                legalMoves = addLegalMove(legalMoves, legalMove);
                            }
                            if (board[startRow - 1][startCol - 1] == ' ') {
                                legalMove = "" + (char) (coord.charAt(0) + 1) + (char) (coord.charAt(1) - 1);
                                legalMoves = addLegalMove(legalMoves, legalMove);
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {
                            // leftmost or rightmost piece; ignore
                        }
                    } else {
                        // king piece
                    }
                } else {
                    // o move
                    if (piece == 'o') {
                        // regular piece
                    } else {
                        // king piece
                    }
                }
            }
            board[startRow][startCol] = ' ';
            board[endRow][endCol] = piece;

            drawBoard(board);
        }
    }
}