import java.util.*;

/*
    AddPairs    
    Owen Wang
    Last modified: 2022-04-27
    Outputs sum of pairs of digits.
*/
public class AddPairs {
    public static void main(String[] args) {
        // variable declaration
        String input;
        int sum = 0;
        Scanner sc = new Scanner(System.in);

        // prompt for input
        System.out.print("Enter number: ");
        input = sc.nextLine();

        if (input.length() % 2 == 0) {
            for (int i = 0; i <= input.length() - 2; i += 2) {
                sum += Integer.parseInt(input.substring(i, i + 2));
            }
        } else {
            for (int i = 0; i <= input.length() - 2; i += 2) {
                sum += Integer.parseInt(input.substring(i, i + 2));
            }
            sum += Integer.parseInt(input.substring(input.length() - 1));
        }
        // output sum
        System.out.println(sum);
    }
}