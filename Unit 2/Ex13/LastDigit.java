import java.util.*;

/*
    LastDigit
    Owen Wang
    Last modified: 2022-03-10

    Prints last digit of input as a word.
*/
public class LastDigit {
    public static void main(String[] args) {
        // variable declaration
        String input;
        int last;
        Scanner sc = new Scanner(System.in);

        // prompt for input
        System.out.print("Enter number: ");
        input = sc.nextLine();

        // determine last number and print
        last = input.charAt(input.length() - 1);
        switch (last) {
            case '1':
                System.out.printf("The last digit of %s is one.", input);
                break;
            case '2':
                System.out.printf("The last digit of %s is two.", input);
                break;
            case '3':
                System.out.printf("The last digit of %s is three.", input);
                break;
            case '4':
                System.out.printf("The last digit of %s is four.\n", input);
                break;
            case '5':
                System.out.printf("The last digit of %s is five.\n", input);
                break;
            case '6':
                System.out.printf("The last digit of %s is six.\n", input);
                break;
            case '7':
                System.out.printf("The last digit of %s is seven.\n", input);
                break;
            case '8':
                System.out.printf("The last digit of %s is eight.\n", input);
                break;
            case '9':
                System.out.printf("The last digit of %s is nine.\n", input);
                break;
            case '0':
                System.out.printf("The last digit of %s is zero.\n", input);
                break;
        }
    }
}
