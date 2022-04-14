import java.util.*;

/*
    DiagonalSmallest
    Owen Wang
    Last modified: 2022-04-14
    Output smallest value in diagonals of 2D array.
*/
public class DiagonalSmallest {
    public static void main(String[] args) {
        // variable declaration
        final int SIZE = 4;
        int smallest = 0, smallest1 = 0, counter = 0, counter1 = SIZE - 1;
        int[][] arr = new int[SIZE][SIZE];
        Scanner sc = new Scanner(System.in);

        // prompt for ints
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print("Enter integer: ");
                arr[i][j] = sc.nextInt();
                if (arr[i][j] > smallest) {
                    smallest = arr[i][j];
                    smallest1 = arr[i][j];
                }
            }
        }

        // determine smallest num in diagonal
        for (int i = 0; i < SIZE; i++) {
            if (arr[i][counter] < smallest) {
                smallest = arr[i][counter];
            }
            if (arr[i][counter1] < smallest1) {
                smallest1 = arr[i][counter1];
            }
            counter++;
            counter1--;
        }

        // output smallest in each diagonal
        System.out.printf("Smallest num in first diagonal: %d\n", smallest);
        System.out.printf("Smallest num in second diagonal: %d\n", smallest1);
    }
}
