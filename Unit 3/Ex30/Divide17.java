import java.util.*;

/*
    Divide17
    Owen Wang
    Last modified: 2022-04-28
    Outputs inputted number divided by 17.
*/
public class Divide17 {
    public static void main(String[] args) {
        // variable declaration
        String x, y;
        double z;
        Scanner sc = new Scanner(System.in);

        // prompt for string
        System.out.print("Enter first number: ");
        x = sc.nextLine();
        System.out.print("Enter second number: ");
        y = sc.nextLine();

        // add two digits together
        z = Double.parseDouble(x + y);

        // output quotient
        System.out.printf("%.2f", z / 17);
    }
}
