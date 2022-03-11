import java.util.*;

/*
    FoodOrder
    Owen Wang
    Last modified: 2022-03-10

    Outputs price of food item user selects.
*/
public class FoodOrder {
    public static void main(String[] args) {
        // variable declaration
        int choice;
        final double OPT1 = 2.50, OPT3 = 3.00, OPT4 = 3.50, OPT5 = 5.00;
        Scanner sc = new Scanner(System.in);

        // prompt user for menu choice
        System.out.println("1) juice, muffin, & coffee");
        System.out.println("2) cereal, toast & milk");
        System.out.println("3) egg, toast & coffee");
        System.out.println("4) banana, granola & milk");
        System.out.println("5) grapefruit, bacon, eggs & coffee");
        choice = sc.nextInt();

        // determine cost of item
        switch (choice) {
            case 1, 2:
                System.out.printf("Price: $%,.2f\n", OPT1);
                break;

            case 3:
                System.out.printf("Price: $%,.2f\n", OPT3);
                break;

            case 4:
                System.out.printf("Price: $%,.2f\n", OPT4);
                break;

            case 5:
                System.out.printf("Price: $%,.2f\n", OPT5);
                break;

            default:
                System.out.println("Invalid option.");
        }
    }
}