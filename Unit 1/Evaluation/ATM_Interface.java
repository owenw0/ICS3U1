import java.util.*;

/*
    ATM_Interface
    Owen Wang
    Last modified: 2022-03-04

    Banking machine's user interface.
*/
public class ATM_Interface {
    public static void main(String[] args) {
        int withdrawal, twenties, fifties;
        final int twenty = 20, fifty = 50;
        Scanner in = new Scanner(System.in);

        System.out.println("==================================================");
        System.out.println("|| // \\\\ //  \"MONEY TIME ATM SERVICE\"  \\\\ // \\\\ ||");
        System.out.println("==================================================\n");

        System.out.print("Amount (in $) to withdraw: ");
        withdrawal = in.nextInt();

        twenties = withdrawal / twenty;
        fifties = withdrawal / fifty;

        System.out.format("\nTo get $%,d, you could receive:\n", withdrawal);
        System.out.format("%dx $20 bills, with $%,d left over\n", twenties, withdrawal - twenties * twenty);
        System.out.println("OR");
        System.out.format("%dx $50 bills, with $%,d left over\n", fifties, withdrawal - fifties * fifty);
    }
}