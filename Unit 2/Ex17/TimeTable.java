import java.util.*;

/*
    TimeTable
    Owen Wang
    Last modified: 2022-03-25
    Outputs times table for inputted value.
*/
public class TimeTable {
    public static void main(String[] args) {
        // variable declaration
        int num;
        Scanner sc = new Scanner(System.in);

        // prompt for number
        System.out.print("Enter number: ");
        num = sc.nextInt();

        // loop through number to print times table
        for (int i = 1; i <= num; i++) {
            System.out.printf("%,d X %,d = %,d\n", num, i, num * i);
        }
    }
}
