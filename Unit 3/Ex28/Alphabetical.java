import java.util.*;

/*
    Alphabetical
    Owen Wang
    Last modified: 2022-04-26
    Determine alphabetical order of two strings.
*/
public class Alphabetical {
    public static void main(String[] args) {
        // variable declaration
        String x, y, result;
        int compare;
        Scanner sc = new Scanner(System.in);

        // prompt for strings
        System.out.print("Enter first string: ");
        x = sc.nextLine();
        System.out.print("Enter second string: ");
        y = sc.nextLine();

        // determine alphabetical order of strings
        compare = x.compareTo(y);
        if (compare == 0) {
            result = "equal";
        } else if (compare >= 0) {
            result = "last";
        } else {
            result = "first";
        }
        System.out.printf("%s is alphabetically %s\n", x, result);
    }
}
