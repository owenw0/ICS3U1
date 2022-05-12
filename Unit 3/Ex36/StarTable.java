import java.util.*;
import java.io.*;

/*
    StarTable
    Owen Wang
    Last modified: 2022-05-12
    Writes star table to file with given dimensions.
*/
public class StarTable {
    public static void main(String[] args) {
        // variable declaration
        String file = "star.txt";
        char[][] stars;
        int rows, cols;
        Scanner sc = new Scanner(System.in);

        // prompt for dimensions
        System.out.print("Enter # rows: ");
        rows = sc.nextInt();
        System.out.print("Enter # cols: ");
        cols = sc.nextInt();

        // initialize and fill array
        stars = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                stars[i][j] = '*';
            }
        }

        // write to file
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(file, false));
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    out.write(stars[i][j]);
                }
                out.newLine();
            }
            out.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
