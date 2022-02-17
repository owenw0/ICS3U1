import java.util.*;

/*
    Fastfood
    Owen Wang
    Last modified: 2022-02-16

    Asks user for number of burgers, fries, and sodas purchased and gives total cost and change due.
*/
public class Fastfood {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int burger_count, fries_count, soda_count;
        float total, amount_given;

        System.out.print("Number of burgers: ");
        burger_count = input.nextInt();
        System.out.print("Number of fries: ");
        fries_count = input.nextInt();
        System.out.print("Number of sodas: ");
        soda_count = input.nextInt();

        total = (float) ((burger_count * 1.69 + fries_count * 1.09 + soda_count * 0.99) * 1.13);

        System.out.format("\nTotal cost: $%.2f\n", total);

        System.out.print("\nAmount given: ");
        amount_given = input.nextFloat();

        System.out.format("Change due: $%.2f\n", amount_given - total);
    }
}
