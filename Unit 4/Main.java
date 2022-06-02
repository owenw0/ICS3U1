import java.util.*;
import java.io.*;

/*
    ATM System
    Owen Wang
    Last modified: 2022-05-30
    Budget ATM System to save banking information.
*/
public class Main {
    public static void menu() {
        // display menu
        System.out.println("\nPress 1 to check balance.");
        System.out.println("Press 2 to deposit money.");
        System.out.println("Press 3 to withdraw money.");
        System.out.println("Press 4 to close an account.");
        System.out.println("Press 5 to open a new account.");
        System.out.println("Press 6 to change PIN.");
        System.out.println("Press 7 to logout.");
    }

    public static void createProfilePrompt(String pin) {
        // variable declaration
        boolean run = true;
        String choice;
        Scanner sc = new Scanner(System.in);

        System.out.println("\nCustomer does not exist.");
        do {
            System.out.print("Would you like to open a new customer profile? (Y/N) ");
            choice = sc.nextLine().toLowerCase();
            switch (choice) {
                case "y", "yes":
                    createProfile(pin);
                    run = false;
                    break;

                case "n", "no":
                    run = false;
                    break;

                default:
                    System.out.println("\nInvalid option.");
            }
        } while (run);
    }

    public static void createProfile(String pin) {
        // variable declaration
        boolean unique = false, run = true;
        String first_name, last_name, num, new_pin = "";
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        BufferedWriter bw;
        BufferedReader br;

        System.out.print("\nEnter first name: ");
        first_name = sc.nextLine();
        System.out.print("Enter last name: ");
        last_name = sc.nextLine();
        // captitalize first letter of name and lowercase rest
        first_name = first_name.substring(0, 1).toUpperCase() + first_name.substring(1).toLowerCase();
        last_name = last_name.substring(0, 1).toUpperCase() + last_name.substring(1).toLowerCase();

        if (pin == "") {
            // if selected to create profile directly
            while (run) {
                System.out.print("\nEnter 4-digit PIN: ");
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
        System.out.printf("Your PIN: %s\n\n", new_pin);

        // write to file
        try {
            bw = new BufferedWriter(new FileWriter(num + ".txt", false));
            bw.write(new_pin);
            bw.write("\n" + first_name);
            bw.write("\n" + last_name);
            bw.close();
        } catch (IOException e) {
        }
    }

    public static String[] retrieveData(String num) {
        // variable declaration
        String acc_type = "", checkings = "X", savings = "X";
        String[] data = new String[5];

        try {
            BufferedReader br = new BufferedReader(new FileReader(num));

            data[0] = br.readLine(); // read PIN
            data[1] = br.readLine(); // read first name
            data[2] = br.readLine(); // read last name

            acc_type = br.readLine();
            if (acc_type == null) {
            } else if (acc_type.equals("CHECKINGS")) {
                // checkings account open
                checkings = br.readLine();
                acc_type = br.readLine();
                // determine if savings account also open
                if (acc_type != null) {
                    savings = br.readLine();
                }
            } else if (acc_type.equals("SAVINGS")) {
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

    public static String[] openAccount(String num, String[] data) {
        // variable declaration
        boolean run = true;
        String checkings = data[3], savings = data[4], choice;
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw;

        // determine how many accounts are open
        if (checkings == "X" && savings == "X") {
            // no accounts open
            System.out.println("Select account to open:");
            System.out.println("    1. Checkings");
            System.out.println("    2. Savings");
            System.out.print("> ");
            choice = sc.nextLine();
            System.out.println();

            do {
                switch (choice) {
                    case "1":
                        // open checkings account
                        System.out.println("Opening checkings account...");
                        checkings = "0";
                        System.out.println("Done.");
                        run = false;
                        break;

                    case "2":
                        // open checkings account
                        System.out.println("Opening savings account...");
                        savings = "0";
                        System.out.println("Done.");
                        run = false;
                        break;

                    default:
                        System.out.println("Invalid option.");
                }
            } while (run);

        } else if (checkings == "X") {
            System.out.print("Open checkings account? (Y/N) ");
            choice = sc.nextLine().toLowerCase();

            do {
                switch (choice) {
                    case "y", "yes":
                        // open checkings account
                        System.out.println("Opening checkings account...");
                        checkings = "0";
                        System.out.println("Done.");
                        run = false;
                        break;

                    case "n", "no":
                        run = false;
                        break;

                    default:
                        System.out.println("Invalid option.");
                }
            } while (run);
        } else if (savings == "X") {
            System.out.print("Open savings account? (Y/N) ");
            choice = sc.nextLine().toLowerCase();

            do {
                switch (choice) {
                    case "y", "yes":
                        // open checkings account
                        System.out.println("Opening savings account...");
                        savings = "0";
                        System.out.println("Done.");
                        run = false;
                        break;

                    case "n", "no":
                        run = false;
                        break;

                    default:
                        System.out.println("Invalid option.");
                }
            } while (run);
        } else {
            System.out.println("All accounts already open.");
        }
        System.out.println();

        // update data
        data[3] = checkings;
        data[4] = savings;

        // update file
        updateFile(num, data);
        return data;
    }

    public static String[] closeAccount(String num, String[] data) {
        // variable declaration
        boolean run = true;
        String checkings = data[3], savings = data[4], choice;
        Scanner sc = new Scanner(System.in);

        // determine how many accounts open
        if (checkings != "X" && savings != "X") {
            // both accounts open
            System.out.println("\nSelect account to close:");
            System.out.println("    1. Checkings");
            System.out.println("    2. Savings");
            choice = sc.nextLine();
            System.out.println();

            do {
                switch (choice) {
                    case "1":
                        System.out.println("Closing checkings account...");
                        checkings = "X";
                        System.out.println("Done.");
                        run = false;
                        break;

                    case "2":
                        System.out.println("Closing savings account...");
                        savings = "X";
                        System.out.println("Done.");
                        run = false;
                        break;

                    default:
                        System.out.println("Invalid option.");
                }
            } while (run);
        } else if (checkings != "X") {
            // close checkings account
            System.out.println("Close checkings account? (Y/N) ");
            choice = sc.nextLine().toLowerCase();
            System.out.println();

            do {
                switch (choice) {
                    case "y", "yes":
                        System.out.println("Closing checkings account...");
                        checkings = "X";
                        System.out.println("Done.");
                        run = false;
                        break;

                    case "n", "no":
                        run = false;
                        break;

                    default:
                        System.out.println("Invalid option.");
                }
            } while (run);
        } else if (savings != "X") {
            // close savings account
            System.out.println("Close savings account? (Y/N) ");
            choice = sc.nextLine().toLowerCase();
            System.out.println();

            do {
                switch (choice) {
                    case "y", "yes":
                        System.out.println("Closing savings account...");
                        savings = "X";
                        System.out.println("Done.");
                        run = false;
                        break;

                    case "n", "no":
                        run = false;
                        break;

                    default:
                        System.out.println("Invalid option.");
                }
            } while (run);
        } else {
            // no accounts open
            System.out.println("ERROR: No accounts open.\n");
        }

        // update data
        data[3] = checkings;
        data[4] = savings;

        // update file
        data = updateFile(num, data);
        return data;
    }

    public static void checkBalance(String[] data) {
        // variable declaration
        boolean run = true;
        String checkings = data[3], savings = data[4], choice;
        Scanner sc = new Scanner(System.in);

        if (checkings != "X" && savings != "X") {
            System.out.println("Select account to check balance:");
            System.out.println("    1. Checkings");
            System.out.println("    2. Savings");
            System.out.print("> ");
            choice = sc.nextLine();
            System.out.println();

            do {
                switch (choice) {
                    case "1":
                        System.out.printf("Checkings balance: $%.2f\n\n", Double.parseDouble(checkings));
                        run = false;
                        break;

                    case "2":
                        System.out.printf("Savings balance: $%.2f\n\n", Double.parseDouble(savings));
                        run = false;
                        break;

                    default:
                        System.out.println("Invalid option.");
                }
            } while (run);
        } else if (checkings != "X") {
            System.out.printf("Checkings balance: $%.2f\n\n", Double.parseDouble(checkings));
        } else if (savings != "X") {
            System.out.printf("Savings balance: $%.2f\n\n", Double.parseDouble(savings));
        } else {
            // no accounts open
            System.out.println("ERROR: No accounts open.\n");
        }
    }

    public static String[] updateFile(String num, String[] data) {
        // variable declaration
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(num, false));
            bw.write(data[0]); // write PIN
            bw.write("\n" + data[1]); // write first name
            bw.write("\n" + data[2]); // write last name
            if (data[3] != "X") {
                bw.write("\nCHECKINGS");
                bw.write("\n" + data[3]); // write checkings balance
            }
            if (data[4] != "X") {
                bw.write("\nSAVINGS");
                bw.write("\n" + data[4]); // write savings balance
            }
            bw.close();
        } catch (IOException e) {
        }
        return data;
    }

    public static String[] deposit(String num, String[] data) {
        // variable declaration
        boolean run = true;
        String checkings = data[3], savings = data[4], choice, deposit;
        Scanner sc = new Scanner(System.in);

        // determine how many accounts open
        if (checkings != "X" && savings != "X") {
            // prompt for account selection
            System.out.println("\nSelect account to deposit to:");
            System.out.println("    1. Checkings");
            System.out.println("    2. Savings");
            System.out.print("> ");
            choice = sc.nextLine();
            System.out.println();

            do {
                switch (choice) {
                    case "1":
                        System.out.print("Deposit amount to checkings: $");
                        deposit = sc.nextLine();
                        try {
                            if (Double.parseDouble(deposit) < 0.01) {
                                System.out.println("Please enter an amount greater than $0");
                            } else {
                                checkings = Double
                                        .toString(Double.parseDouble(deposit) + Double.parseDouble(checkings));
                                run = false;
                            }
                        } catch (NumberFormatException e) {
                            // invalid amount entered
                            System.out.println("Please enter a number.");
                        }
                        break;

                    case "2":
                        System.out.print("Deposit amount to savings: $");
                        deposit = sc.nextLine();
                        try {
                            if (Double.parseDouble(deposit) < 0.01) {
                                System.out.println("Please enter an amount greater than $0");
                            } else {
                                savings = Double.toString(Double.parseDouble(deposit) + Double.parseDouble(savings));
                                run = false;
                            }
                        } catch (NumberFormatException e) {
                            // invalid amount entered
                            System.out.println("Please enter a number.");
                        }
                        break;

                    default:
                        System.out.println("Invalid option.");
                }
            } while (run);
            System.out.println();

        } else if (checkings != "X") {
            // checkings account open
            do {
                System.out.print("Deposit amount to checkings: $");
                deposit = sc.nextLine();
                try {
                    if (Double.parseDouble(deposit) < 0.01) {
                        System.out.println("Please enter an amount greater than $0");
                    } else {
                        checkings = Double.toString(Double.parseDouble(deposit) + Double.parseDouble(checkings));
                        run = false;
                    }
                } catch (NumberFormatException e) {
                    // invalid amount entered
                    System.out.println("Please enter a number.");
                }
            } while (run);
            System.out.println();

        } else if (savings != "X") {
            // savings account open
            do {
                System.out.print("Deposit amount to savings: $");
                deposit = sc.nextLine();
                try {
                    if (Double.parseDouble(deposit) < 0.01) {
                        System.out.println("Please enter an amount greater than $0");
                    } else {
                        savings = Double.toString(Double.parseDouble(deposit) + Double.parseDouble(savings));
                        run = false;
                    }
                } catch (NumberFormatException e) {
                    // invalid amount entered
                    System.out.println("Please enter a number.");
                }
            } while (run);
            System.out.println();

        } else {
            // no accounts open
            System.out.println("ERROR: No accounts open.\n");
        }

        // update data
        data[3] = checkings;
        data[4] = savings;

        // update file
        data = updateFile(num, data);
        return data;
    }

    public static String[] withdraw(String num, String[] data) {
        // variable declaration
        boolean run = true;
        String checkings = data[3], savings = data[4], choice, withdrawal;
        Scanner sc = new Scanner(System.in);

        // determine how many accounts open
        if (checkings != "X" && savings != "X") {
            // prompt for account selection
            System.out.println("\nSelect account to withdraw from:");
            System.out.println("    1. Checkings");
            System.out.println("    2. Savings");
            System.out.print("> ");
            choice = sc.nextLine();
            System.out.println();

            do {
                switch (choice) {
                    case "1":
                        System.out.print("Withdraw amount from checkings: $");
                        withdrawal = sc.nextLine();
                        try {
                            if (Double.parseDouble(checkings) < Double.parseDouble(withdrawal)) {
                                System.out.println("Withdrawal amount too large.");
                            } else {
                                checkings = Double
                                        .toString(Double.parseDouble(checkings) - Double.parseDouble(withdrawal));
                            }
                            run = false;
                        } catch (NumberFormatException e) {
                            // invalid amount entered
                            System.out.println("Please enter a number.");
                        }
                        break;

                    case "2":
                        System.out.print("Withdraw amount from savings: $");
                        withdrawal = sc.nextLine();
                        try {
                            if (Double.parseDouble(savings) < Double.parseDouble(withdrawal)) {
                                System.out.println("Withdrawal amount too large.");
                            } else {
                                checkings = Double
                                        .toString(Double.parseDouble(savings) - Double.parseDouble(withdrawal));
                            }
                            run = false;
                        } catch (NumberFormatException e) {
                            // invalid amount entered
                            System.out.println("Please enter a number.");
                        }
                        break;

                    default:
                        System.out.println("Invalid option.");
                }
            } while (run);
            System.out.println();

        } else if (checkings != "X") {
            // checkings account open
            do {
                System.out.print("Withdraw amount from checkings: $");
                withdrawal = sc.nextLine();
                try {
                    if (Double.parseDouble(checkings) < Double.parseDouble(withdrawal)) {
                        System.out.println("Withdrawal amount too large.");
                    } else {
                        checkings = Double
                                .toString(Double.parseDouble(checkings) - Double.parseDouble(withdrawal));
                    }
                    run = false;
                } catch (NumberFormatException e) {
                    // invalid amount entered
                    System.out.println("Please enter a number.");
                }
            } while (run);
            System.out.println();

        } else if (savings != "X") {
            // savings account open
            do {
                System.out.print("Withdraw amount from savings: $");
                withdrawal = sc.nextLine();
                try {
                    if (Double.parseDouble(savings) < Double.parseDouble(withdrawal)) {
                        System.out.println("Withdrawal amount too large.");
                    } else {
                        checkings = Double
                                .toString(Double.parseDouble(savings) - Double.parseDouble(withdrawal));
                    }
                    run = false;
                } catch (NumberFormatException e) {
                    // invalid amount entered
                    System.out.println("Please enter a number.");
                }
            } while (run);
            System.out.println();

        } else {
            // no accounts open
            System.out.println("ERROR: No accounts open.\n");
        }

        // update data
        data[3] = checkings;
        data[4] = savings;

        // update file
        data = updateFile(num, data);
        return data;
    }

    public static String[] changePIN(String num, String[] data) {
        // variable declaration
        boolean run = true, input_pin = true;
        String cur_pin, new_pin, confirm_pin, choice;
        Scanner sc = new Scanner(System.in);

        do {
            // prompt for PIN change
            System.out.println("Change PIN? (Y/N) ");
            choice = sc.nextLine().toLowerCase();
            System.out.println();

            switch (choice) {
                case "y", "yes":
                    // prompt for new PIN
                    System.out.print("Enter current PIN: ");
                    cur_pin = sc.nextLine();

                    // confirm current PIN
                    if (cur_pin.equals(data[0])) {
                        do {
                            System.out.print("\nEnter new 4-digit PIN: ");
                            new_pin = sc.nextLine();

                            if (new_pin.equals(data[0])) {
                                // if new PIN is the same as current PIN
                                System.out.println("\nNew PIN cannot be same as current PIN.");
                                input_pin = false;
                            } else if (new_pin.length() != 4) {
                                System.out.print("\nInvalid PIN.");
                            } else {
                                try {
                                    Integer.parseInt(new_pin);
                                    // confirm PIN
                                    System.out.print("Confirm PIN: ");
                                    confirm_pin = sc.nextLine();
                                    if (confirm_pin.equals(new_pin)) {
                                        // update data
                                        data[0] = new_pin;
                                        data = updateFile(num, data);
                                        System.out.println("PIN successfully changed.\n");
                                        input_pin = false;
                                    } else {
                                        System.out.println("Invalid PIN.");
                                        input_pin = false;
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.print("\nInvalid PIN.");
                                }
                            }
                        } while (input_pin);
                    } else {
                        System.out.println("Incorrect PIN.\n");
                    }
                    run = false;
                    break;

                case "n", "no":
                    run = false;
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        } while (run);

        return data;
    }

    public static void main(String[] args) {
        // variable declaration
        boolean menu = true, run = true;
        String num, pin = "", file_pin, first_name, choice = "";
        String[] data;
        Scanner sc = new Scanner(System.in);
        BufferedReader br;

        // main loop
        while (true) {
            // reset variables
            menu = true;
            run = true;

            // prompt for user information
            System.out.print("\nEnter 6-digit customer number (C to create new profile): ");
            num = sc.nextLine();

            if (num.toLowerCase().equals("c")) {
                // if user wants to create new profile
                createProfile("");
                run = false;
            } else {
                try {
                    num += ".txt";
                    br = new BufferedReader(new FileReader(num));
                } catch (FileNotFoundException e) {
                    // customer does not exist
                    System.out.print("Enter PIN: ");
                    pin = sc.nextLine();
                    if (pin.length() != 4) {
                        createProfilePrompt("");
                    } else {
                        try {
                            Integer.parseInt(pin);
                            createProfilePrompt(pin);
                        } catch (NumberFormatException x) {
                            // invalid PIN
                            createProfilePrompt("");
                        }
                    }
                    run = false;
                }
            }

            while (run) {
                System.out.print("Enter PIN: ");
                pin = sc.nextLine();
                System.out.println();

                if (pin.toLowerCase().equals("x")) {
                    // if user cancels login
                    run = false;
                } else {
                    try {
                        br = new BufferedReader(new FileReader(num));
                        // confirm PIN
                        file_pin = br.readLine();
                        if (pin.equals(file_pin)) {
                            first_name = br.readLine();
                            System.out.printf("\nWelcome %s!", first_name);
                            br.close();
                            run = false;

                            // retrieve data
                            data = retrieveData(num);

                            // display menu
                            menu();
                            do {

                                System.out.print("> ");
                                choice = sc.nextLine();
                                System.out.println();

                                switch (choice) {
                                    case "1":
                                        // call checkBalance method
                                        checkBalance(data);
                                        // display menu
                                        menu();
                                        break;

                                    case "2":
                                        // call deposit method
                                        data = deposit(num, data);
                                        menu();
                                        break;

                                    case "3":
                                        // call withdrawal method
                                        data = withdraw(num, data);
                                        menu();
                                        break;

                                    case "4":
                                        // call closeAccount method
                                        data = closeAccount(num, data);
                                        menu();
                                        break;

                                    case "5":
                                        // call openAccount method
                                        data = openAccount(num, data);
                                        menu();
                                        break;

                                    case "6":
                                        // call changePIN method
                                        data = changePIN(num, data);
                                        menu = false;
                                        break;

                                    case "7":
                                        // exit out of loop and logout
                                        System.out.println("Logging out...\n");
                                        menu = false;
                                        break;

                                    default:
                                        // output error message if invalid number entered
                                        System.out.println("Invalid option.");
                                }
                            } while (menu);
                        } else {
                            // incorrect user PIN entered
                            System.out.println("\nIncorrect PIN. Enter X to cancel.");
                        }
                    } catch (IOException e) {
                    }
                }
            }
        }
    }
}
