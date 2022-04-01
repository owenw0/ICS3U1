import java.util.*;

/*
    Rectangle
    Owen Wang
    Last modified: 2022-04-01
    Outputs a rectangle with inputted dimensions.
*/
public class Rectangle {
    public static void main(String[] args) {
        // variable declaration
        int rows, cols;
        Scanner sc = new Scanner(System.in);

        // prompt for rows and cols
        System.out.print("Enter # of rows: ");
        rows = sc.nextInt();
        System.out.print("Enter # of columns: ");
        cols = sc.nextInt();

        // output rectangle
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
