import java.util.*;

/*
    Factors
    Owen Wang
    Last modified: 2022-03-28
    Outputs all factors of a number.
*/
public class Factors {
    public static void main(String[] args) {
        // variable declaration
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int number = sc.nextInt();

        // loop through factors
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                System.out.println(i);
            }
        }
    }
}