import java.util.*;

/*
    CheckLine
    Owen Wang
    Last modified: 2022-05-03
    Calculate different properties of lines.
*/
public class CheckLine {
    public static void main(String[] args) {
        // variable declaration
        int x1, y1, x2, y2;
        double length1, length2, slope1, slope2;
        Scanner sc = new Scanner(System.in);

        // prompt for coordinates
        System.out.println("Please enter the two coordinates of line 1:");
        System.out.print("Vertex 1 x-value: ");
        x1 = sc.nextInt();
        System.out.print("Vertex 1 y-value: ");
        y1 = sc.nextInt();
        System.out.println();
        System.out.print("Vertex 2 x-value: ");
        x2 = sc.nextInt();
        System.out.print("Vertex 2 y-value: ");
        y2 = sc.nextInt();

        // determine length and slope of line 1
        length1 = Line.length(x1, y1, x2, y2);
        slope1 = Line.slope(x1, y1, x2, y2);

        // prompt for coordinates
        System.out.println("Please enter the two coordinates of line 2:");
        System.out.print("Vertex 1 x-value: ");
        x1 = sc.nextInt();
        System.out.print("Vertex 1 y-value: ");
        y1 = sc.nextInt();
        System.out.println();
        System.out.print("Vertex 2 x-value: ");
        x2 = sc.nextInt();
        System.out.print("Vertex 2 y-value: ");
        y2 = sc.nextInt();

        length2 = Line.length(x1, y1, x2, y2);
        slope2 = Line.slope(x1, y1, x2, y2);

        // determine results
        System.out.println("\nResults:");
        if (length1 == length2) {
            System.out.println("The two lines have the same length.");
        } else {
            System.out.println("The two lines do not have the same length.");
        }
        if (slope1 == slope2) {
            System.out.println("The two lines are parallel.");
        } else {
            System.out.println("The two lines are not parallel.");
        }
    }
}
