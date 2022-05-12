import java.util.*;
import java.io.*;

/*
    DivideLoop
    Owen Wang
    Last modified: 2022-05-12
    Read input and output each char on newline.
*/
public class DivideLoop {
    public static void main(String[] args) {
        // variable declaration
        String num, div;
        double numerator, divisor;
        Scanner sc = new Scanner(System.in);

        // prompt for input
        System.out.print("Enter the numerator: ");
        num = sc.nextLine();

        while (num.charAt(0) != 'q' && num.charAt(0) != 'Q') {
            try {
                // determine quotient
                System.out.print("Enter the divisor: ");
                div = sc.nextLine();
                if (Double.parseDouble(div) == 0) {
                    System.out.printf("You can't divide %s by 0\n", num);
                } else {
                    System.out.printf("%.2f / %.2f is %f\n", Double.parseDouble(num), Double.parseDouble(div),
                            Double.parseDouble(num) / Double.parseDouble(div));
                }
                System.out.print("\nEnter the numerator: ");
                num = sc.nextLine();
            } catch (NumberFormatException e) {
                System.out.println("You entered bad data.");
                System.out.println("Please try again.\n");
            }
        }
    }
}