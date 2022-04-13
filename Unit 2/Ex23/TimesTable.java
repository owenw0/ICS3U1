import java.util.*;

/*
    TimesTable
    Owen Wang
    Last modified: 2022-04-13
    Output times table.
*/
public class TimesTable {
    public static void main(String[] args) {
        // variable declaration
        final int LENGTH = 12;
        int[][] table = new int[LENGTH][LENGTH];

        // create table
        // creates header
        System.out.print("    ");
        for (int i = 1; i <= LENGTH; i++) {
            System.out.printf("%-4d", i);
        }
        System.out.println();

        // fills table
        for (int i = 1; i <= LENGTH; i++) {
            for (int j = 1; j <= LENGTH; j++) {
                table[i - 1][j - 1] = i * j;
            }
        }

        // outputs table
        for (int i = 0; i < LENGTH; i++) {
            System.out.printf("%-4d", i + 1);
            for (int j = 0; j < LENGTH; j++) {
                System.out.printf("%-4d", table[i][j]);
            }
            System.out.println();
        }
    }
}
