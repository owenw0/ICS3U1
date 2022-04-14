import java.util.*;

/*
    Array2DOddEven
    Owen Wang
    Last modified: 2022-04-13
    Outputs even/odd status of 2D array.
*/
public class Array2DOddEven {
    public static void main(String[] args) {
        // variable declaration
        final int SIZE = 3;
        int status;
        boolean error = false, col_error = false, col1_error = false, col2_error = false;
        int col, col1, col2;
        int[][] arr = new int[SIZE][SIZE];
        Scanner sc = new Scanner(System.in);

        // prompt for ints
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print("Enter integer: ");
                arr[i][j] = sc.nextInt();
            }
        }
        col = arr[0][0] % 2;
        col1 = arr[0][1] % 2;
        col2 = arr[0][2] % 2;

        // determine status
        for (int i = 0; i < SIZE; i++) {
            // col status
            if (arr[i][0] % 2 != col) {
                col_error = true;
            }
            if (arr[i][1] % 2 != col) {
                col1_error = true;
            }
            if (arr[i][2] % 2 != col) {
                col2_error = true;
            }

            // row status
            error = false;
            status = arr[i][0] % 2;
            for (int j = 0; j < SIZE && !error; j++) {
                if (arr[i][j] % 2 != status) {
                    System.out.printf("Row %d not all even/odd\n", i);
                    error = true;
                }
            }
            // output row status
            if (error == false) {
                if (status == 1) {
                    System.out.printf("Row %d all odd.\n", i);
                } else {
                    System.out.printf("Row %d all even.\n", i);
                }
            }
        }
        // output col status
        if (col_error) {
            System.out.println("Column 1 not all even/odd.");
        } else if (col == 1) {
            System.out.println("Column 1 all odd.");
        } else {
            System.out.println("Column 1 all even.");
        }

        if (col1_error) {
            System.out.println("Column 2 not all even/odd.");
        } else if (col1 == 1) {
            System.out.println("Column 2 all odd.");
        } else {
            System.out.println("Column 2 all even.");
        }

        if (col2_error) {
            System.out.println("Column 3 not all even/odd.");
        } else if (col2 == 1) {
            System.out.println("Column 3 all odd.");
        } else {
            System.out.println("Column 3 all even.");
        }
    }
}
