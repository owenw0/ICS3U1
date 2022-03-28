import java.util.*;

/*
    NumberSum
    Owen Wang
    Last modified: 2022-03-28
    Adds up integers inputted.
*/
public class NumberSum {
    public static void main(String[] args) {
        // variable declaration
        int n, num, total = 0;
        Scanner sc = new Scanner(System.in);

        // prompt for num of ints entered
        System.out.print("How many integers will be added? ");
        n = sc.nextInt();

        // loop
        for (int i = 0; i < n; i++) {
            System.out.print("Enter an integer: ");
            num = sc.nextInt();
            total += num;
        }
        System.out.printf("\nThe sum is %d", total);
    }
}
