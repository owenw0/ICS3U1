import java.util.*;
import java.io.*;

/*
    ATM System
    Owen Wang
    Last modified: 2022-05-30
    Budget ATM System to save banking information.
*/
public class Main {
    public static boolean create_profile(String pin) {
        // variable declaration
        boolean run = true, unique = false;
        String choice, last_name, first_name, num;
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        BufferedWriter bw;
        BufferedReader br;

        System.out.println("Customer does not exist.");
        while (run) {
            // prompt for whether user would like to open new profile
            System.out.print("Would you like to open a new customer profile? (Y/N) ");
            choice = sc.nextLine().toLowerCase();
            switch (choice) {
                case "y":
                    // prompt for name
                    System.out.print("\nEnter last name: ");
                    last_name = sc.nextLine();
                    System.out.print("Enter first name: ");
                    first_name = sc.nextLine();

                    last_name = last_name.substring(0, 1).toUpperCase() + last_name.substring(1).toLowerCase();
                    first_name = first_name.substring(0, 1).toUpperCase() + first_name.substring(1).toLowerCase();

                    // confirm customer number
                    do {
                        // generate random number
                        num = Integer.toString(random.nextInt(100000, 999999));
                        // determine if number is unique
                        try {
                            br = new BufferedReader(new FileReader(num + ".txt"));
                            unique = true;
                        } catch (IOException e) {
                        }
                    } while (unique = false);

                    System.out.printf("\nYour customer number: %s\n", num);

                    // confirm PIN
                    while (pin.length() != 4) {
                        System.out.print("Enter 4-digit PIN: ");
                        pin = sc.nextLine();
                    }
                    System.out.printf("Your PIN: %s\n\n", pin);

                    // write to file
                    try {
                        bw = new BufferedWriter(new FileWriter(num + ".txt", false));
                        bw.write(num + "\n");
                        bw.write(pin + "\n");
                        bw.write(last_name + "\n");
                        bw.write(first_name + "\n");
                        bw.close();
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                    return true;

                case "n":
                    return false;

                default:
                    System.out.println("Invalid option, try again.");
            }
        }
        return true;
    }

    public static void open_account(String num) {
        // variable declaration
        String acc_type = "", temp = "";
        BufferedReader br;
        BufferedWriter bw;

        try {
            br = new BufferedReader(new FileReader(num + ".txt"));
            // read through basic information
            for (int i = 0; i < 4; i++) {
                br.readLine();
            }

            acc_type = br.readLine();
            if (acc_type == null) {
                // no accounts open
                // prompt for which account to open
                System.out.println("Select account to open:");
                System.out.println("    1: Checkings");
                System.out.println("    2: Savings");
            } else {
                for (int i = 0; i < 2; i++) {
                    temp = br.readLine();
                }
                if (temp == null) {
                    // only one account open
                    if (acc_type == "SAVINGS") {
                        System.out.println("Opening checkings account.");
                        try {
                            bw = new BufferedWriter(new FileWriter(num + ".txt", true));
                            bw.write("CHECKINGS");
                            bw.write("0");
                        } catch (IOException e) {
                        }
                    } else {
                        System.out.println("Opening savings account.");
                        try {
                            bw = new BufferedWriter(new FileWriter(num + ".txt", true));
                            bw.write("SAVINGS");
                            bw.write("0");
                        } catch (IOException e) {
                        }
                    }
                }
            }
        } catch (IOException e) {
        }
    }

    public static void check_balance(String num) {
        // variable declaration
        boolean run = true;
        String checkings_balance = "", savings_balance = "", open_account = "", acc_type = "";
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        BufferedReader br;

        try {
            br = new BufferedReader(new FileReader(num + ".txt"));
            // read first 5 lines (basic customer info)
            for (int i = 0; i < 5; i++) {
                acc_type = br.readLine();
            }

            // check if any accounts are open
            if (acc_type == null) {
                System.out.println("\nERROR: No open accounts.");
                System.out.println("Would you like to open an account? (Y/N) ");
                open_account = sc.nextLine().toLowerCase();
                switch (open_account) {
                    case "y":
                    case "yes":
                        open_account(num);
                        break;

                    case "n":
                    case "no":
                        // return to menu
                        System.out.println();
                        break;

                    default:
                        System.out.println("Invalid option, try again.");
                }
            } else {
                if (acc_type == "CHECKINGS") {
                    checkings_balance = br.readLine();
                } else {
                    savings_balance = br.readLine();
                }

                acc_type = br.readLine();
                if (acc_type == null) {
                    if (checkings_balance != null) {
                        System.out.printf("Checkings balance: $%.2f\n", checkings_balance);
                    } else {
                        System.out.printf("Savings balance: $%.2f\n", savings_balance);
                    }
                } else {
                    if (acc_type == "CHECKINGS") {
                        checkings_balance = br.readLine();
                    } else {
                        savings_balance = br.readLine();
                    }

                    // prompt for account selection
                    System.out.println("Select account:");
                    System.out.println("    1: Checkings");
                    System.out.println("    2: Savings");

                    while (run) {
                        try {
                            System.out.print("[> ");
                            choice = sc.nextInt();
                            if (choice == 1) {
                                System.out.printf("Checkings balance: $%.2f\n", checkings_balance);
                                run = false;
                            } else if (choice == 2) {
                                System.out.printf("Savings balance: $%.2f\n", savings_balance);
                                run = false;
                            } else {
                                // if number is not 1 or 2
                                System.out.println("Invalid option.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid option.");
                        }
                    }
                }
            }
        } catch (IOException e) {
        }
    }

    public static void main(String[] args) {
        // variable declaration
        boolean logged_in = true, menu = true;
        String num, pin, file_PIN, line = "", last_name, first_name;
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        BufferedReader br;

        // main loop
        while (true) {
            while (logged_in) {
                // promt for user information
                System.out.print("Enter 6-digit customer number: ");
                num = sc.nextLine();
                System.out.print("Enter PIN: ");
                pin = sc.nextLine();
                try {
                    br = new BufferedReader(new FileReader(num + ".txt"));
                    line = br.readLine();
                    // read PIN
                    file_PIN = br.readLine();
                    if (pin.equals(file_PIN)) {
                        // retrieve information from file
                        last_name = br.readLine();
                        first_name = br.readLine();
                        br.close();
                        do {
                            // display menu
                            System.out.println("\nPress 1 to check balance.");
                            System.out.println("Press 2 to deposit money.");
                            System.out.println("Press 3 to withdraw money.");
                            System.out.println("Press 4 to close an account.");
                            System.out.println("Press 5 to open a new account.");
                            System.out.println("Press 6 to change PIN.");
                            System.out.println("Press 7 to logout.");
                            try {
                                choice = sc.nextInt();
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid option.");
                            }

                            if (menu) {
                                switch (choice) {
                                    case 1:
                                        // call check_balance method
                                        check_balance(num);
                                        menu = false;
                                        break;

                                    case 2:
                                        // call deposit method
                                        menu = false;
                                        break;

                                    case 3:
                                        // call withdraw method
                                        menu = false;
                                        break;

                                    case 4:
                                        // call close_account method
                                        menu = false;
                                        break;

                                    case 5:
                                        // call open_account method
                                        menu = false;
                                        break;

                                    case 6:
                                        // call change_PIN method
                                        menu = false;
                                        break;

                                    case 7:
                                        // exit out of loop and logout
                                        menu = false;
                                        break;

                                    default:
                                        // output error message
                                        System.out.println("Invalid option.");
                                }
                            }
                        } while (menu);
                    } else {
                        System.out.println("Incorrect PIN.\n");
                    }
                } catch (IOException e) {
                    if (create_profile(pin) == false) {
                        System.out.println();
                        logged_in = false;
                    }
                }
            }
            logged_in = true;
        }
    }
}
