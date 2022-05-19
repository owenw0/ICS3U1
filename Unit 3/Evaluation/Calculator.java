import java.util.*;

/*
    Calculator
    Owen Wang
    Last modified: 2022-05-19
    Makeshift calculator app using methods.
*/
public class Calculator {
    // addition method
    public static double add(double num1, double num2) {
        return num1 + num2;
    }

    // subtraction method
    public static double subtract(double num1, double num2) {
        return num1 - num2;
    }

    // multiplication method
    public static double multiply(double num1, double num2) {
        return num1 * num2;
    }

    // division method
    public static double divide(double num1, double num2) {
        return num1 / num2;
    }

    // square root method
    public static double sqrt(double num) {
        return Math.sqrt(num);
    }

    // power method
    public static double pow(double num1, double num2) {
        return Math.pow(num1, num2);
    }

    public static void main(String[] args) {
        // variable declaration
        boolean run = true;
        char choice;
        double num1, num2;
        Scanner sc = new Scanner(System.in);

        while (run) {
            // prompt for selection
            System.out.println("[A]dd");
            System.out.println("[S]ubtract");
            System.out.println("[M]ultiply");
            System.out.println("[D]ivide");
            System.out.println("Square [R]oot");
            System.out.println("[P]ower");
            System.out.println("[Q]uit");
            System.out.print("Please choose what you would like to do: ");
            choice = Character.toLowerCase(sc.next().charAt(0));

            // determine instructions
            try {
                switch (choice) {
                    // quit program
                    case 'q':
                        System.out.println("Program ending!");
                        run = false;
                        break;

                    // call addition method
                    case 'a':
                        System.out.print("First number: ");
                        num1 = sc.nextDouble();
                        System.out.print("Second number: ");
                        num2 = sc.nextDouble();
                        System.out.printf("%f + %f = %.2f\n\n", num1, num2, add(num1, num2));
                        break;

                    // call subtraction method
                    case 's':
                        System.out.print("First number: ");
                        num1 = sc.nextDouble();
                        System.out.print("Second number: ");
                        num2 = sc.nextDouble();
                        System.out.printf("%f - %f = %.2f\n\n", num1, num2, subtract(num1, num2));
                        break;

                    // call multiplication method
                    case 'm':
                        System.out.print("First number: ");
                        num1 = sc.nextDouble();
                        System.out.print("Second number: ");
                        num2 = sc.nextDouble();
                        System.out.printf("%f x %f = %.2f\n\n", num1, num2, multiply(num1, num2));
                        break;

                    // call division method
                    case 'd':
                        System.out.print("First number: ");
                        num1 = sc.nextDouble();
                        System.out.print("Second number: ");
                        num2 = sc.nextDouble();
                        System.out.printf("%f / %f = %.2f\n\n", num1, num2, divide(num1, num2));
                        break;

                    // call square root method
                    case 'r':
                        System.out.print("Number: ");
                        num1 = sc.nextDouble();
                        System.out.printf("The square root of %f is %.2f\n\n", num1, sqrt(num1));
                        break;

                    // call power method
                    case 'p':
                        System.out.print("First number: ");
                        num1 = sc.nextDouble();
                        System.out.print("Second number: ");
                        num2 = sc.nextDouble();
                        System.out.printf("%f to the power of %f is %.2f\n\n", num1, num2, pow(num1, num2));
                        break;

                    // input is invalid
                    default:
                        System.out.println("Invalid selection, please try again\n");
                }
                // non-number value was entered
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number value!\n");
            }
        }
    }
}