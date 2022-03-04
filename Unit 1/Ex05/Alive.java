import java.util.*;

/*
    Alive
    Owen Wang
    Last modified: 2022-02-15

    Asks user for birthdate and current date and outputs total days alive and time asleep.
    (assuming user sleeps 8 hours a birth_day)
*/
public class Alive {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int birth_year, birth_month, birth_day;
        int current_year, current_month, current_day;
        int days_alive;

        System.out.println("Enter your birthdate:");
        System.out.print("Year: ");
        birth_year = input.nextInt();
        System.out.print("Month: ");
        birth_month = input.nextInt();
        System.out.print("Day: ");
        birth_day = input.nextInt();

        System.out.println("Enter today's date:");
        System.out.print("Year: ");
        current_year = input.nextInt();
        System.out.print("Month: ");
        current_month = input.nextInt();
        System.out.print("Day: ");
        current_day = input.nextInt();

        days_alive = 365 * (current_year - (++birth_year)); // years since birth
        days_alive += 30 * (current_month - 1) + current_day; // days since start of current year
        days_alive += (30 - birth_day) + (30 * (12 - birth_month)); // remaining days from birth year
        System.out.println("You have been alive for " + days_alive + " days.");
        System.out.println("You have slept " + days_alive * 8 + " hours.");
    }
}
