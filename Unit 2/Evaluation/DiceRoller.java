import java.util.*;

/*
    DiceRoller
    Owen Wang
    Last modified: 2022-04-25
    Simulates rolling a dice.
*/
public class DiceRoller {
    public static void main(String[] args) {
        // variable declaration
        int[] sides = { 4, 6, 8, 10, 20 };
        int choice, roll;
        boolean error = true;
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        // display menu
        System.out.println("========== ELECTRONIC DICE ROLLER ==========");
        System.out.println("Please enter the number for the kind of die you would like to roll:");
        System.out.printf("%-14s (generates numbers 1 to 4)\n", "4-sided die");
        System.out.printf("%-14s (generates numbers 1 to 6)\n", "6-sided die");
        System.out.printf("%-14s (generates numbers 1 to 8)\n", "8-sided die");
        System.out.printf("%-14s (generates numbers 1 to 10)\n", "10-sided die");
        System.out.printf("%-14s (generates numbers 1 to 20)\n", "20-sided die");

        // prompt for choice
        System.out.print("\nWhat kind of die do you want to roll? ");
        choice = sc.nextInt();

        for (int i = 0; i < sides.length && error; i++) {
            if (choice == sides[i]) {
                error = false;
            }
        }

        // output random number choice in range
        if (!error) {
            roll = random.nextInt(1, choice + 1);
            System.out.printf("\nYou rolled a: %d", roll);
            if (choice == 20) {
                if (roll == 1) {
                    System.out.println("\nVERY BAD");
                } else if (roll >= 2 && roll <= 9) {
                    System.out.println("\nPoor roll");
                } else if (roll >= 10 && roll <= 14) {
                    System.out.println("\nAverage roll");
                } else if (roll >= 15 && roll <= 19) {
                    System.out.println("\nGood roll");
                } else {
                    System.out.println("\nVERY GOOD");
                }
            }
        } else {
            System.out.println("\nINVALID OPTION");
        }
    }
}
