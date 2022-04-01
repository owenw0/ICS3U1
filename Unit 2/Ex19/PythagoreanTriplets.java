import java.util.*;

/*
    PythagoreanTriplets
    Owen Wang
    Last modified: 2022-04-01
    Prints all Pythagorean triplets whose largest num <= prompted int.
*/
public class PythagoreanTriplets {
    public static void main(String[] args) {
        // variable declaration
        int in;
        double root;
        Scanner sc = new Scanner(System.in);

        // prompt for positive integer
        System.out.print("Enter positive integer: ");
        in = sc.nextInt();

        // loop through triples
        for (int i = 1; i <= in; i++) {
            for (int j = 1; j <= i; j++) {
                root = Math.sqrt(Math.pow(i, 2) + Math.pow(j, 2));
                if (root <= in && root == (int) root) {
                    System.out.printf("%d, %d, %d\n", j, i, (int) root);
                }
            }
        }
    }
}