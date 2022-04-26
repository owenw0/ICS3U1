import java.util.*;

/*
    FirstLast
    Owen Wang
    Last modified: 2022-04-26
    Output first and last character of string.
*/
public class FirstLast {
    public static void main(String[] args) {
        // variable declaration
        String input;
        Scanner sc = new Scanner(System.in);

        // prompt for string
        System.out.print("Enter string: ");
        input = sc.nextLine();

        // output first and last char
        System.out.printf("%c, %c", input.charAt(0), input.charAt(input.length() - 1));
    }
}
