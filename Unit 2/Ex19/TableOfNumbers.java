import java.util.*;

/*
    TableOfNumbers
    Owen Wang
    Last modified: 2022-04-01
    Outputs table of numbers.
*/
public class TableOfNumbers {
    public static void main(String[] args) {
        // variable declaration
        int x, y;
        Scanner sc = new Scanner(System.in);

        // prompt for x and y
        System.out.print("Enter x: ");
        x = sc.nextInt();
        System.out.print("Enter y: ");
        y = sc.nextInt();

        // loop through nums to print table
        for (int i = 0; i < x; i++) {
            for (int j = 1; j <= y; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
