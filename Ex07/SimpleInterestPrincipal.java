import java.util.*;

/*
    SimpleInterestPrincipal
    Owen Wang
    Last modified: 2022-02-24

    Outputs initial amount that needs to be invested in order to achieve certain amount of money.
*/
public class SimpleInterestPrincipal {
    public static void main(String[] args) {
        double amount, principal, years, interest;
        Scanner in = new Scanner(System.in);

        System.out.print("Enter desired amount: $");
        amount = in.nextDouble();
        System.out.print("Enter years passed: ");
        years = in.nextDouble();
        System.out.print("Enter interest rate (decimal): ");
        interest = in.nextDouble();

        System.out.printf("Required initial deposit: $%.2f\n", amount / (1 + years * interest));
    }
}