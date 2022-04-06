import java.util.*;

/*
    Numbers
    Owen Wang
    Last modified: 2022-04-06
    Some number shenanigans.
*/
public class Numbers {
    public static void main(String[] args) {
        // variable declaration
        double s[] = new double[6];
        double num;
        Scanner sc = new Scanner(System.in);

        // prompt for numbers:
        System.out.println("Enter 6 numbers:");
        for (int i = 0; i < s.length; i++) {
            System.out.printf("Enter number %d: ", i + 1);
            s[i] = sc.nextDouble();
        }

        // print in reverse
        System.out.println("\nPrinting in reverse:");
        for (int i = s.length - 1; i >= 0; i--) {
            System.out.println(s[i]);
        }

        // add 10% to each value in array
        for (int i = 0; i < s.length; i++) {
            s[i] = s[i] * 1.1;
        }

        System.out.println("\nPrinting all values over 50 (after 10% increase):");
        // print all values over 50
        for (int i = 0; i < s.length; i++) {
            if (s[i] > 50) {
                System.out.println(s[i]);
            }
        }
    }
}
