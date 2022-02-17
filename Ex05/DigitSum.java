import java.util.*;

/*
    DigitSum
    Owen Wang
    Last modified: 2022-02-16

    Finds sum of the digits of given 3-digit number, then prints both given number and sum.
*/
public class DigitSum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num, x, sum = 0;

        System.out.print("Enter 3-digit number: ");
        num = input.nextInt();
        x = num;

        while (x > 0) {
            sum = sum + x % 10;
            x = x / 10;
        }

        System.out.println("\nGiven digit: " + num);
        System.out.println("Sum of digits: " + sum);
    }
}
