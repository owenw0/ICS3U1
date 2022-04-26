import java.util.*;

/*
    Exponent
    Owen Wang
    Last modified: 2022-04-26
    Outputs b^e.
*/
public class Exponent {
    public static void main(String[] args) {
        // variable declaration
        int base, exp;
        Scanner sc = new Scanner(System.in);

        // prompt user for variables
        System.out.print("Enter base: ");
        base = sc.nextInt();
        System.out.print("Enter exponent: ");
        exp = sc.nextInt();

        // output answer
        System.out.println((int) Math.pow(base, exp));
    }
}
