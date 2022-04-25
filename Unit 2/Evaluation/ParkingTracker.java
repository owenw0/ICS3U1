import java.util.*;

/*
    ParkingTracker
    Owen Wang
    Last modified: 2022-04-25
    Track parking spots.
*/
public class ParkingTracker {
    public static void main(String[] args) {
        // variable declaration
        final int ARR_ROWS = 3, ARR_COLS = 4;
        int row, col, available;
        boolean error = false;
        char[][] parking = new char[ARR_ROWS][ARR_COLS];
        Scanner sc = new Scanner(System.in);

        // fill parking array
        for (int i = 0; i < ARR_ROWS; i++) {
            for (int j = 0; j < ARR_COLS; j++) {
                parking[i][j] = ' ';
            }
        }

        while (!error) {
            available = 0;
            // display parking lot and info
            System.out.println("\n  0123");
            System.out.println(" +----+");
            for (int i = 0; i < ARR_ROWS; i++) {
                System.out.printf("%d|", i);
                for (int j = 0; j < ARR_COLS; j++) {
                    System.out.print(parking[i][j]);
                    if (parking[i][j] == ' ') {
                        available++;
                    }
                }
                System.out.println("|");
            }
            System.out.println(" +----+");

            System.out.printf("\nThere are %d spots available.\n", available);

            // prompt for selection
            System.out.print("Please choose a row:     ");
            row = sc.nextInt();
            System.out.print("Please choose a column:  ");
            col = sc.nextInt();

            // determine if invalid option
            if (row > ARR_ROWS || col > ARR_COLS) {
                System.out.println("\nInvalid spot!  Program ending.");
                error = true;
            } else {
                // confirm spot
                if (parking[row][col] == ' ') {
                    parking[row][col] = 'X';
                    System.out.printf("Spot %d-%d filled!\n", row, col);
                } else {
                    parking[row][col] = ' ';
                    System.out.printf("Spot %d-%d emptied!\n", row, col);
                }
            }
        }
    }
}
