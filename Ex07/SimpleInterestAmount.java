import java.util.*;

/*
    SimpleInterestAmount
    Owen Wang
    Last modified: 2022-02-24

    Calculates total amount of interest given principal, interest rate, and years.
*/
public class SimpleInterestAmount {
    public static void main(String[] args) {
        double amount, principal, years, interest;
        Scanner in = new Scanner(System.in);

        System.out.print("Enter inital amount: $");
        principal = in.nextDouble();
        System.out.print("Enter years passed: ");
        years = in.nextDouble();
        System.out.print("Enter interest rate (decimal): ");
        interest = in.nextDouble();

        System.out.printf("Amount: $%.2f\n", principal * (1 + years * interest));
    }
}
