import java.util.*;

/*
    Spending
    Owen Wang
    Last modified: 2022-02-24

    Displays percentage budget spent when given spending list.
*/
public class Spending {
    public static void main(String[] args) {
        double food, clothing, entertainment, rent, total;
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the amount spent last month on the following item:\n");

        System.out.print("Food: $");
        food = input.nextDouble();
        System.out.print("Clothing: $");
        clothing = input.nextDouble();
        System.out.print("Entertainment: $");
        entertainment = input.nextDouble();
        System.out.print("Rent: $");
        rent = input.nextDouble();

        total = food + clothing + entertainment + rent;

        System.out.printf("%-17s%s\n", "Clothing", "Budget");
        System.out.printf("%-17s%.2f%%\n", "Food", (food / total) * 100);
        System.out.printf("%-17s%.2f%%\n", "Clothing", (clothing / total) * 100);
        System.out.printf("%-17s%.2f%%\n", "Entertainment", (entertainment / total) * 100);
        System.out.printf("%-17s%.2f%%\n", "Rent", (rent / total) * 100);
    }
}
