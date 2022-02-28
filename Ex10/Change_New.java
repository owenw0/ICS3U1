import java.util.*;

/*
    Change_New
    Owen Wang
    Last modified: 2022-02-28

    Displays min # of coins necessary to make change given amount in cents.
*/
public class Change {
    public static void main(String[] args) {
        int toonies, loonies, quarters, dimes, nickels;
        double amount;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the amount (in dollars): $");
        amount = input.nextDouble();
        amount = (int) (amount * 100);

        System.out.println("The minimum number of coins is:");

        toonies = (int) amount / 200;
        amount -= toonies * 200;
        loonies = (int) amount / 100;
        amount -= loonies * 100;
        quarters = (int) amount / 25;
        amount -= quarters * 25;
        dimes = (int) amount / 10;
        amount -= dimes * 10;
        nickels = (int) amount / 5;
        amount -= nickels * 5;

        System.out.printf("    Toonies: %d\n", toonies);
        System.out.printf("    Loonies: %d\n", loonies);
        System.out.printf("    Quarters: %d\n", quarters);
        System.out.printf("    Dimes: %d\n", dimes);
        System.out.printf("    Nickels: %d\n", nickels);
        System.out.printf("    Leftover Cents: %d\n", (int) amount);
    }
}
