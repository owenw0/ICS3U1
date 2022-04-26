import java.util.*;

/*
    StringLen    
    Owen Wang
    Last modified: 2022-04-26
    Outputs length of string.
*/
public class StringLen {
    public static void main(String[] args) {
        // variable declaration
        String input;
        Scanner sc = new Scanner(System.in);

        // prompt user for string
        System.out.print("Enter string: ");
        input = sc.nextLine();

        // output length of string
        System.out.println(input.length());
    }
}
