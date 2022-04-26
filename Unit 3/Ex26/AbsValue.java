import java.util.*;

/*
    AbsValue
    Owen Wang
    Last modified: 2022-04-26
    Outputs absolute value of number.
*/
public class AbsValue {
    public static void main(String[] args) {
        // variable declaration
        int num;
        Scanner sc = new Scanner(System.in);

        // prompt user for number
        System.out.print("Enter number: ");
        num = sc.nextInt();

        // output abs value of number
        System.out.println(Math.abs(num));
    }
}
