import java.util.*;

/*
    AddDigits
    Owen Wang
    Last modified: 2022-04-26
    Outputs sum of digits.
*/
public class AddDigits {
    public static void main(String[] args) {
        // variable declaration
        int input, sum = 0;
        Scanner sc = new Scanner(System.in);

        // prompt for input
        System.out.print("Enter number: ");
        input = sc.nextInt();

        // output sum of digits
        while (input > 0) {
            sum = sum + input % 10;
            input = input / 10;
        }
        System.out.println(sum);
    }
}
