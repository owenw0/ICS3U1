import java.util.*;

/*
    LeastTwoPower
    Owen Wang
    Last modified: 2022-03-21

    Finds smallest power of 2 that is greater than inputted number.
*/
public class LeastTwoPower {
    public static void main(String[] args) {
        // variable input
        int pow = 0, num;
        Scanner sc = new Scanner(System.in);

        // prompt for num
        System.out.print("Input number: ");
        num = sc.nextInt();

        // loop through powers of 2
        while (Math.pow(2, pow) < num) {
            pow++;
        }
        System.out.printf("%d is the smallest power of two >= to num.\n", pow);
    }
}
