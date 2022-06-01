import java.util.*;
import java.io.*;

/*
    ATM System
    Owen Wang
    Last modified: 2022-05-30
    Budget ATM System to save banking information.
*/
public class Main {
    public static String[] retrieve_data(String num) {
        // variable declaration
        String pin = "", last_name = "", first_name = "", acc_type = "", checkings = "", savings = "";
        String[] data = new String[5];

        try {
            BufferedReader br = new BufferedReader(new FileReader(num));

            pin = br.readLine();
            data[0] = pin;
            last_name = br.readLine();
            data[1] = last_name;
            first_name = br.readLine();
            data[2] = first_name;

            acc_type = br.readLine();
            if (acc_type == null) {
                // no accounts open
                checkings = "0";
                savings = "0";
            } else if (acc_type == "CHECKINGS") {
                // checkings account open
                checkings = br.readLine();
                acc_type = br.readLine();
                // determine if savings account also open
                if (acc_type != null) {
                    savings = br.readLine();
                }
            } else if (acc_type == "SAVINGS") {
                // savings account open
                savings = br.readLine();
                acc_type = br.readLine();
                // determine if checkings account also open
                if (acc_type != null) {
                    checkings = br.readLine();
                }
            }
            data[3] = checkings;
            data[4] = savings;
        } catch (IOException e) {
        }
        return data;
    }

    public static String[] create_profile(String pin) {
        // variable declaration
        boolean unique = false, run = true;
        String last_name, first_name, num, new_pin = "";
        String[] data = new String[5];
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        BufferedWriter bw;
        BufferedReader br;

        System.out.print("\nEnter last name: ");
        last_name = sc.nextLine();
        System.out.print("Enter first name: ");
        first_name = sc.nextLine();
        // captitalize first letter of name and lowercase rest
        last_name = last_name.substring(0, 1).toUpperCase() + last_name.substring(1).toLowerCase();
        first_name = first_name.substring(0, 1).toUpperCase() + first_name.substring(1).toLowerCase();

        if (pin == "c") {
            // if selected to create profile directly
            while (run) {
                System.out.print("Enter 4-digit PIN: ");
                new_pin = sc.nextLine();
                if (new_pin.length() != 4) {
                    System.out.println("\nInvalid PIN.");
                } else {
                    try {
                        Integer.parseInt(new_pin);
                        run = false;
                    } catch (NumberFormatException e) {
                        System.out.println("\nInvalid PIN.");
                    }
                }
            }
        } else {
            new_pin = pin;
        }

        do {
            // generate random customer number
            num = Integer.toString(random.nextInt(100000, 999999));
            // determine if number is unique
            try {
                br = new BufferedReader(new FileReader(num + ".txt"));
                unique = true;
            } catch (IOException e) {
            }
        } while (unique = false);

        System.out.printf("\n\nYour customer number: %s\n", num);
        System.out.printf("Your PIN: %s\n", new_pin);

        // write to file
        try {
            bw = new BufferedWriter(new FileWriter(num + ".txt", false));
            bw.write(new_pin + "\n");
            bw.write(last_name + "\n");
            bw.write(first_name + "\n");
            bw.close();
        } catch (IOException e) {
        }

        data[0] = pin;
        data[1] = last_name;
        data[2] = first_name;
        return data;
    }

    public static String[] create_profile_prompt(String pin) {
        // variable declaration
        boolean run = true;
        String choice;
        String data[] = new String[5];
        Scanner sc = new Scanner(System.in);

        System.out.println("Invalid customer number.");
        do {
            System.out.print("Would you like to open a new customer profile? (Y/N) ");
            choice = sc.nextLine().toLowerCase();
            switch (choice) {
                case "y", "yes":
                    data = create_profile(pin);
                    run = false;
                    break;

                case "n", "no":
                    run = false;
                    break;

                default:
                    System.out.println("\nInvalid option.");
            }
        } while (run);
        return data;
    }

    public static void main(String[] args) {
        // variable declaration
        boolean menu = true, open_prof = false, valid_pin = false, run = true;
        String num, pin = "c", file_pin, open_profile;
        String[] data;
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        BufferedReader br;

        // main loop
        while (true) {
            // reset variables
            pin = "c";
            menu = true;
            open_prof = false;
            valid_pin = false;
            run = true;

            // prompt for user information
            System.out.print("\nEnter 6-digit customer number (C to create new profile): ");
            num = sc.nextLine();

            if (num.toLowerCase().equals("c")) {
                create_profile(pin);
                run = false;
            } else if (num.length() != 6) {
                data = create_profile_prompt(pin);
                run = false;
            } else {
                try {
                    Integer.parseInt(num);
                } catch (NumberFormatException e) {
                    data = create_profile_prompt(pin);
                    run = false;
                }
            }
            num += ".txt";

            while (run) {
                System.out.print("Enter PIN: ");
                pin = sc.nextLine();

                try {
                    Integer.parseInt(pin);
                    try {
                        br = new BufferedReader(new FileReader(num));
                        // confirm PIN
                        file_pin = br.readLine();
                        if (pin.equals(file_pin)) {
                            br.close();
                            run = false;
                            // retrieve data
                            data = retrieve_data(num);
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
                                    // prompt for choice
                                    System.out.println("> ");
                                    choice = sc.nextInt();
                                } catch (InputMismatchException e) {
                                    // if string or float was entered
                                    System.out.println("Invalid option.");
                                }

                                switch (choice) {
                                    case 1:
                                        // call check_balance method
                                        break;

                                    case 7:
                                        // exit out of loop and logout
                                        System.out.println("Logging out...");
                                        menu = false;
                                        break;

                                    default:
                                        // output error message if invalid number entered
                                        System.out.println("Invalid option.");
                                }
                            } while (menu);
                        } else {
                            // incorrect user PIN entered
                            System.out.println("\nIncorrect PIN.");
                        }
                    } catch (IOException e) {
                        // file not found
                        System.out.println("User does not exist.");

                        data = create_profile_prompt(pin);
                        run = false;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("\nInvalid PIN.");
                }
            }
        }
    }
}
