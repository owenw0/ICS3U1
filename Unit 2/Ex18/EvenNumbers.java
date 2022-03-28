import java.util.*;

/*
    EvenNumbers
    Owen Wang
    Last modified: 2022-03-28
    Outputs sum of ints entered.
*/
public class EvenNumbers {
    public static void main(String[] args) {
        // variable declaration
        int num = 0, evens = 0;
        Scanner sc = new Scanner(System.in);

        // loop prompt for ints
        do {
            System.out.print("Enter an integer: ");
            num = sc.nextInt();
            if (num % 2 == 0 && num > 0) {
                evens++;
            }
        } while (num > 0);
        System.out.printf("You have entered %d even numbers", evens);
    }
}
