import java.util.*;

/*
    Change
    Owen Wang
    Last modified: 2022-02-24

    Displays min # of coins necessary to make change given amount in cents.
*/
public class Change {
    public static void main(String[] args) {
        int amount, toonies, loonies, quarters, dimes, nickels;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the amount (in cents): ");
        amount = input.nextInt();

        System.out.println("The minimum number of coins is:");

        toonies = amount / 200;
        amount -= toonies * 200;
        loonies = amount / 100;
        amount -= loonies * 100;
        quarters = amount / 25;
        amount -= quarters * 25;
        dimes = amount / 10;
        amount -= dimes * 10;
        nickels = amount / 5;
        amount -= nickels * 5;

        System.out.printf("    Toonies: %d\n", toonies);
        System.out.printf("    Loonies: %d\n", loonies);
        System.out.printf("    Quarters: %d\n", quarters);
        System.out.printf("    Dimes: %d\n", dimes);
        System.out.printf("    Nickels: %d\n", nickels);
        System.out.printf("    Leftover Cents: %d\n", amount);
    }
}
