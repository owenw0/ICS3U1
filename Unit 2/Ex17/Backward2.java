import java.util.*;

/*
    Backward2
    Owen Wang
    Last modified: 2022-03-25
    Counts down from 100 to inputted number by 5.
*/
public class Backward2 {
    public static void main(String[] args) {
        // variable declaration
        int limit;
        Scanner sc = new Scanner(System.in);

        // prompt for lower bound num
        System.out.print("Enter lower bound number: ");
        limit = sc.nextInt();

        // loop
        for (int i = 100; i >= limit; i -= 5) {
            System.out.println(i);
        }
    }
}
