import java.util.*;

/*
    StarTable
    Owen Wang
    Last modified: 2022-04-13
    Output 2D table.
*/
public class StarTable {
    public static void main(String[] args) {
        // variable declaration
        char[][] table;
        int length, width;
        Scanner sc = new Scanner(System.in);

        // prompt for dimensions
        System.out.print("Enter length: ");
        length = sc.nextInt();
        System.out.print("Enter width: ");
        width = sc.nextInt();

        // create table
        table = new char[length][width];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                table[i][j] = '*';
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(table[i][j]);
            }
            System.out.println();
        }
    }
}
