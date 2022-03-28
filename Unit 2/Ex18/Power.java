import java.util.*;

/*
    Power
    Owen Wang
    Last modified: 2022-03-28
    Computes X to the power of n.
*/
public class Power {
    public static void main(String[] args) {
        // variable declaration
        double x, total = 1;
        int n;
        Scanner sc = new Scanner(System.in);

        // prompt for x and n
        System.out.println("Enter X");
        x = sc.nextDouble();
        System.out.println("Enter N");
        n = sc.nextInt();

        if (n > 0) {
            // loop through power
            for (int i = 1; i <= n; i++) {
                total = total * x;
            }
        } else {
            System.out.println("\nN must be a positive integer.");
        }
        System.out.printf("\n%f raised to the power %d is: %f", x, n, total);
    }
}
