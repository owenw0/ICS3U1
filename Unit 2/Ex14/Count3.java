import java.util.*;

/*
    Count3
    Owen Wang
    Last modified: 2022-03-21

    Loops through entered a and b values by 1.
*/
public class Count3 {
    public static void main(String[] args) {
        // variable declaration
        int a, b;
        Scanner sc = new Scanner(System.in);

        // prompt for a and b
        System.out.print("Enter num a: ");
        a = sc.nextInt();
        System.out.print("Enter num b: ");
        b = sc.nextInt();

        // loop
        while (a <= b) {
            System.out.println(a);
            a++;
        }
    }
}
