import java.util.*;

/*
    Discriminant
    Owen Wang
    Last modified: 2022-03-08

    Determine # of roots of function.
*/
public class Discriminant {
    public static void main(String[] args) {
        double a, b, c;
        int roots;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter 'a' value: ");
        a = sc.nextDouble();
        System.out.print("Enter 'b' value: ");
        b = sc.nextDouble();
        System.out.print("Enter 'c' value: ");
        c = sc.nextDouble();

        // determines root amount
        if (Math.pow(b, 2) - 4 * a * c > 0) {
            roots = 2;
        } else if (Math.pow(b, 2) - 4 * a * c == 0) {
            roots = 1;
        } else {
            roots = 0;
        }

        if (roots == 2) {
            System.out.println("Two roots");
        } else if (roots == 1) {
            System.out.println("One root");
        } else {
            System.out.println("No roots");
        }
    }
}
