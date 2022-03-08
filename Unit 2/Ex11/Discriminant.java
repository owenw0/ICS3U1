import java.util.*;

/*
    Discriminant
    Owen Wang
    Last modified: 2022-03-08

    Determine # of roots of function.
*/
public class Discriminant {
    public static void main(String[] args) {
        // variable declaration
        double a, b, c, discriminant;
        int roots;
        Scanner sc = new Scanner(System.in);

        // prompts user for values
        System.out.print("Enter 'a' value: ");
        a = sc.nextDouble();
        System.out.print("Enter 'b' value: ");
        b = sc.nextDouble();
        System.out.print("Enter 'c' value: ");
        c = sc.nextDouble();

        discriminant = Math.pow(b, 2) - 4 * a * c; // calculates discriminant

        // determines root amount
        if (discriminant > 0) {
            roots = 2;
        } else if (discriminant == 0) {
            roots = 1;
        } else {
            roots = 0;
        }

        // outputs # of roots
        if (roots == 2) {
            System.out.println("Two roots");
        } else if (roots == 1) {
            System.out.println("One root");
        } else {
            System.out.println("No roots");
        }
    }
}
