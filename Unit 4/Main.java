import java.util.*;
import java.io.*;

/*
    ATM System
    Owen Wang
    Last modified: 2022-05-25
    Budget ATM System to save banking information.
*/
public class Main {
    public static boolean create_profile(String pin) {
        // variable declaration
        boolean run = true;
        String choice, last_name, first_name, confirm, num;
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        BufferedWriter bw;

        System.out.println("Customer does not exist.");
        while (run) {
            // prompt for whether user would like to open new profile
            System.out.print("Would you like to open a new customer profile? (Y/N) ");
            choice = sc.nextLine().toLowerCase();
            if (choice == "y") {
                // prompt for name
                System.out.print("Enter last name: ");
                last_name = sc.nextLine();
                System.out.print("Enter first name: ")
                first_name = sc.nextLine();
                
                
                last_name = last_name.substring(0, 1).toUpperCase() + last_name.substring(1).toLowerCase();
                first_name = first_name.substring(0, 1).toUpperCase() + first_name.substring(1).toLowerCase();

                // confirm PIN
                System.out.printf("Your PIN: %s", pin);

                // confirm customer number
                num = Integer.toString(random.nextInt(100000, 999999));
                System.out.printf("Your customer number: %s", num);

                // write to file
                bw = new BufferedWriter(num);
                bw.write(num + "\n");
                bw.write(pin + "\n");
                bw.write(last_name + "\n");
                bw.write(first_name + "\n");
                bw.close();

                return true;
            } else if (choice == "n") {
                return false;
            } else {
                System.out.println("Invalid option, try again.");
            }
        }
    }

    public static void main(String[] args) {
        // variable declaration
        boolean logged_in = true;
        String num, pin, line = "";
        Scanner sc = new Scanner(System.in);

        // main loop
        while (true) {
            while (logged_in) {
                // promt for user information
                System.out.print("Enter 6-digit customer number: ");
                num = sc.nextLine();
                System.out.print("Enter PIN: ");
                pin = sc.nextLine();
                try {
                    BufferedReader br = new BufferedReader(new FileReader(num));
                    line = br.readLine();
                } catch (IOException e) {
                    if (create_profile(pin) == false) {
                        logged_in = false;
                    }
                }
            }
        }
    }
}
