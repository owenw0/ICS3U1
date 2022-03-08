import java.util.*;

/*
    CheckInt
    Owen Wang
    Last modified: 2022-03-08

    Determines if inputted integer is positive/negative, even/odd, multiple of 7.
*/
public class CheckInt {
    public static void main(String[] args) {
        int input;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter integer: ");
        input = sc.nextInt();

        // determines if integer is positive or negative
        if (input >= 0) {
            System.out.println("Positive");
        } else {
            System.out.println("Negative");
        }

        // determines if integer is even or odd
        if (input % 2 == 0) {
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }

        // determine if integer is a multiple of 7
        if (input % 7 == 0) {
            System.out.println("Is multiple of 7");
        } else {
            System.out.println("Not multiple of 7");
        }
    }
}
