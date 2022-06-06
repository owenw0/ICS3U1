import java.util.*;

public class Checkers {
    public static char board[][] = new char[8][8];

    public static void drawBoard() {
        for (int i = 1; i < 9; ++i) {
            System.out.print("   " + i);
        }
        System.out.print("\n  ");
        for (int i = 0; i < 8; ++i)
            System.out.print("+---");
        System.out.print("+\n");
        for (int i = 0; i < 8; ++i) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 8; ++j) {
                System.out.print("| " + board[i][j] + " ");
            }
            System.out.print("|\n  ");
            for (int i2 = 0; i2 < 8; ++i2)
                System.out.print("+---");
            System.out.print("+\n");
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 8; ++i)
            for (int j = 0; j < 8; ++j)
                board[i][j] = ' ';
        for (int i = 0; i < 3; ++i) {
            if (i % 2 == 0) {
                for (int j = 1; j < 8; j += 2)
                    board[i][j] = 'x';
            } else {
                for (int j = 0; j < 8; j += 2)
                    board[i][j] = 'x';
            }
        }
        for (int i = 7; i > 4; --i) {
            if (i % 2 == 0) {
                for (int j = 1; j < 8; j += 2)
                    board[i][j] = 'o';
            } else {
                for (int j = 0; j < 8; j += 2)
                    board[i][j] = 'o';
            }
        }
        drawBoard();
        int user = 0;
        Scanner in = new Scanner(System.in);
        while (true) { // This loop ends when the game has been finished
            if (user == 0)
                user = 1; // Chages the player
            else
                user = 0;
            int sw = 0, once = 1, row1 = 0, col1 = 0; // ONCE=0 -> User should move on force | ONCE=1 -> user should
                                                      // insert columns
            while (sw == 0) // This loop ends when the player entered valid numbers
            {
                ArrayList<Path> cellsMustGo = new ArrayList<>();
                sw = 1;
                for (int i = 0; i < 8; ++i) {
                    for (int j = 0; j < 8; ++j) {
                        if (once == 0) {
                            i = row1;
                            j = col1;
                        }
                        Cell now = new Cell(i, j);
                        if (user == 0 && board[i][j] == 'x') {
                            if (i < 6 && j > 1 && (board[i + 1][j - 1] == 'o' || board[i + 1][j - 1] == 'O')
                                    && board[i + 2][j - 2] == ' ') {
                                cellsMustGo.add(new Path(now, new Cell(i + 2, j - 2)));
                                sw = 0;
                            }
                            if (i < 6 && j < 6 && (board[i + 1][j + 1] == 'o' || board[i + 1][j + 1] == 'O')
                                    && board[i + 2][j + 2] == ' ') {
                                cellsMustGo.add(new Path(now, new Cell(i + 2, j + 2)));
                                sw = 0;
                            }
                        } else if (user == 1 && board[i][j] == 'o') {
                            if (i > 1 && j > 1 && (board[i - 1][j - 1] == 'x' || board[i - 1][j - 1] == 'X')
                                    && board[i - 2][j - 2] == ' ') {
                                cellsMustGo.add(new Path(now, new Cell(i - 2, j - 2)));
                                sw = 0;
                            }
                            if (i > 1 && j < 6 && (board[i - 1][j + 1] == 'x' || board[i - 1][j + 1] == 'X')
                                    && board[i - 2][j + 2] == ' ') {
                                cellsMustGo.add(new Path(now, new Cell(i - 2, j + 2)));
                                sw = 0;
                            }
                        } else if (user == 0 && board[i][j] == 'X') // when user 1 wants to move its king
                        {
                            if (i > 1 && j > 1 && (board[i - 1][j - 1] == 'o' || board[i - 1][j - 1] == 'O')
                                    && board[i - 2][j - 2] == ' ') {
                                cellsMustGo.add(new Path(now, new Cell(i - 2, j - 2)));
                                sw = 0;
                            }
                            if (i > 1 && j < 6 && (board[i - 1][j + 1] == 'o' || board[i - 1][j + 1] == 'O')
                                    && board[i - 2][j + 2] == ' ') {
                                cellsMustGo.add(new Path(now, new Cell(i - 2, j + 2)));
                                sw = 0;
                            }
                            if (i < 6 && j > 1 && (board[i + 1][j - 1] == 'o' || board[i + 1][j - 1] == 'O')
                                    && board[i + 2][j - 2] == ' ') {
                                cellsMustGo.add(new Path(now, new Cell(i + 2, j - 2)));
                                sw = 0;
                            }
                            if (i < 6 && j < 6 && (board[i + 1][j + 1] == 'o' || board[i + 1][j + 1] == 'O')
                                    && board[i + 2][j + 2] == ' ') {
                                cellsMustGo.add(new Path(now, new Cell(i + 2, j + 2)));
                                sw = 0;
                            }
                        } else if (user == 1 && board[i][j] == 'O') // when user O wants to move its king
                        {
                            if (i > 1 && j > 1 && (board[i - 1][j - 1] == 'x' || board[i - 1][j - 1] == 'X')
                                    && board[i - 2][j - 2] == ' ') {
                                cellsMustGo.add(new Path(now, new Cell(i - 2, j - 2)));
                                sw = 0;
                            }
                            if (i > 1 && j < 6 && (board[i - 1][j + 1] == 'x' || board[i - 1][j + 1] == 'X')
                                    && board[i - 2][j + 2] == ' ') {
                                cellsMustGo.add(new Path(now, new Cell(i - 2, j + 2)));
                                sw = 0;
                            }
                            if (i < 6 && j > 1 && (board[i + 1][j - 1] == 'x' || board[i + 1][j - 1] == 'X')
                                    && board[i + 2][j - 2] == ' ') {
                                cellsMustGo.add(new Path(now, new Cell(i + 2, j - 2)));
                                sw = 0;
                            }
                            if (i < 6 && j < 6 && (board[i + 1][j + 1] == 'x' || board[i + 1][j + 1] == 'X')
                                    && board[i + 2][j + 2] == ' ') {
                                cellsMustGo.add(new Path(now, new Cell(i + 2, j + 2)));
                                sw = 0;
                            }
                        }
                        if (once == 0)
                            break;
                    } // end j loop
                    if (once == 0)
                        break;
                } // end i loop

                if (sw == 1) {
                    break;
                } else {
                    System.out.print("User " + (user + 1)
                            + " please choose one of the cell(s) that show below for next move : \n");
                    int it = 1;
                    for (Path p : cellsMustGo) {
                        System.out.println(it + ". " + (p.getStart().getRow() + 1) + "|" + (p.getStart().getCol() + 1)
                                + " to " + (p.getEnd().getRow() + 1) + "|" + (p.getEnd().getCol() + 1));
                        it++;
                    }
                    int tmp = in.nextInt();
                    row1 = cellsMustGo.get(tmp - 1).getEnd().getRow();
                    col1 = cellsMustGo.get(tmp - 1).getEnd().getCol();
                    board[row1][col1] = board[cellsMustGo.get(tmp - 1).getStart().getRow()][cellsMustGo.get(tmp - 1)
                            .getStart().getCol()];
                    board[cellsMustGo.get(tmp - 1).getStart().getRow()][cellsMustGo.get(tmp - 1).getStart()
                            .getCol()] = ' ';
                    int newRow = (cellsMustGo.get(tmp - 1).getStart().getRow() + row1) / 2;
                    int newCol = (cellsMustGo.get(tmp - 1).getStart().getCol() + col1) / 2;
                    if (user == 0 && row1 == 7 && board[row1][col1] == 'x')
                        board[row1][col1] = 'X'; // user 1 became king
                    if (user == 1 && row1 == 0 && board[row1][col1] == 'o')
                        board[row1][col1] = 'O'; // user 2 became king
                    board[newRow][newCol] = ' ';
                    once = 0;
                }
                drawBoard();
            } // end while1 loop
            if (once == 1) {
                do {
                    System.out.print("User " + (user + 1) + ": Enter row of start cell: \n"); // read numbers from
                                                                                              // input
                    int startRow = in.nextInt(); //
                    System.out.print("User " + (user + 1) + ": Enter column of start cell: \n"); //
                    int startCol = in.nextInt(); //
                    System.out.print("User " + (user + 1) + ": Enter row of end cell: \n"); //
                    int endRow = in.nextInt(); //
                    System.out.print("User " + (user + 1) + ": Enter column of end cell: \n"); //
                    int endCol = in.nextInt(); //
                    startRow--; //
                    startCol--; //
                    endRow--; //
                    endCol--; // end

                    if (startRow > -1 && startRow < 8 && startCol > -1 && startCol < 8 && endRow > -1 && endRow < 8
                            && endCol > -1 && endCol < 8 && board[endRow][endCol] == ' ') {
                        if (user == 0 && board[startRow][startCol] == 'x') // User 1 moves its bead
                        {
                            if (endRow == startRow + 1 && (endCol == startCol - 1 || endCol == startCol + 1)) {
                                board[endRow][endCol] = 'x';
                                board[startRow][startCol] = ' ';
                                if (user == 0 && endRow == 7 && board[endRow][endCol] == 'x')
                                    board[endRow][endCol] = 'X'; // the bead changes into king
                                break;
                            }
                        } else if (user == 1 && board[startRow][startCol] == 'o') // User 2 moves its bead
                        {
                            if (endRow == startRow - 1 && (endCol == startCol - 1 || endCol == startCol + 1)) {
                                board[endRow][endCol] = 'o';
                                board[startRow][startCol] = ' ';
                                if (user == 1 && endRow == 0 && board[endRow][endCol] == 'o')
                                    board[endRow][endCol] = 'O'; // the bead changes into king
                                break;
                            }
                        } else if (user == 0 && board[startRow][startCol] == 'X') // user 1 moves its King
                        {
                            if ((endRow == startRow - 1 || endRow == startRow + 1)
                                    && (endCol == startCol - 1 || endCol == startCol + 1)) {
                                board[endRow][endCol] = 'X';
                                board[startRow][startCol] = ' ';
                                break;
                            }
                        } else if (user == 1 && board[startRow][startCol] == 'O') // user 2 moves its King
                        {
                            if ((endRow == startRow - 1 || endRow == startRow + 1)
                                    && (endCol == startCol - 1 || endCol == startCol + 1)) {
                                board[endRow][endCol] = 'O';
                                board[startRow][startCol] = ' ';
                                break;
                            }
                        }
                    }
                    System.out.println("Please enter x valid path !");
                } while (true);
                drawBoard();
            }
            int cntA = 0, cntB = 0;
            for (int i = 0; i < 8; ++i) { // counts number of beads (X for user1 O for User O)
                for (int j = 0; j < 8; ++j) {
                    if (board[i][j] == 'x' || board[i][j] == 'X')
                        cntA++;
                    if (board[i][j] == 'o' || board[i][j] == 'O')
                        cntB++;
                }
            }
            if (cntA == 0) {
                System.out.println("User 2 win!");
                break;
            }
            if (cntB == 0) {
                System.out.println("User 1 win!");
                break;
            }
        } // end of the game!
    }

}

class Cell {
    public int row, col;

    Cell(int r, int c) {
        this.row = r;
        this.col = c;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

}

class Path {
    public Cell start, end;

    Path(Cell s, Cell e) {
        this.start = s;
        this.end = e;
    }

    public Cell getStart() {
        return start;
    }

    public Cell getEnd() {
        return end;
    }

    public void setStart(Cell start) {
        this.start = start;
    }

    public void setEnd(Cell end) {
        this.end = end;
    }
}