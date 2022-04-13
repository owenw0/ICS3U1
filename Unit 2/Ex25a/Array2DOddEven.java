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
        boolean status;
        int[][] arr = new int[SIZE][SIZE];
        int[] status = new int[SIZE];
        Scanner sc = new Scanner(System.in);

        // prompt for ints
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print("Enter integer: ");
                arr[i][j] = sc.nextInt();
            }
        }

        // determine status
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                status = arr[i][j] % 2;
            }
        }
    }
}
