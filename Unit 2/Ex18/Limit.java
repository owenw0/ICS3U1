import java.util.*;

/*
    Limit
    Owen Wang
    Last modified: 2022-03-28
    Computes a sum
*/
public class Limit {
    public static void main(String[] args) {
        // variable declaration
        int n;
        double total = 0;
        Scanner sc = new Scanner(System.in);

        // prompt for n
        System.out.println("Enter N");
        n = sc.nextInt();

        // loop through sum
        for (int i = 1; i <= n; i++) {
            total += 1.0 / i;
        }
        System.out.printf("\nSum is: %f", total);
    }
}
