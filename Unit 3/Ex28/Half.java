import java.util.*;

/*
    Half
    Owen Wang
    Last modified: 2022-04-26
    Break string in half.
*/
public class Half {
    public static void main(String[] args) {
        // variable declaration
        String input, first, last;
        Scanner sc = new Scanner(System.in);

        // prompt user for string
        System.out.print("Enter string: ");
        input = sc.nextLine();

        // output first and lsat half of string
        first = input.substring(0, input.length() / 2);
        last = input.substring(input.length() / 2, input.length());
        System.out.println(first);
        System.out.println(last);
    }
}
