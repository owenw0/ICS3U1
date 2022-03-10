import java.util.*;

/*
    SortThreeNumbers
    Owen Wang
    Last modified: 2022-03-10

    Prompts for three whole numbers and outputs sorted.
*/
public class SortThreeNumbers {
    public static void main(String[] args) {
        // variable declaration
        int big, mid, small, temp;
        Scanner sc = new Scanner(System.in);

        // prompts user for three ints
        System.out.println("Enter three positive whole numbers:");
        System.out.print("Number 1: ");
        big = sc.nextInt();
        System.out.print("Number 2: ");
        mid = sc.nextInt();
        System.out.print("Number 3: ");
        small = sc.nextInt();

        // determines if all numbers are valid
        if (big > 0 && mid > 0 && small > 0) {
            // ensures that the var small holds the smallest number
            if (small > big) {
                temp = big;
                big = small;
                small = temp;
            }
            if (small > mid) {
                temp = mid;
                mid = small;
                small = temp;
            }
            // ensures that the var mid holds the 2nd largest number;
            if (mid > big) {
                temp = big;
                big = mid;
                mid = temp;
            }
            // outputs numbers in ascending order
            System.out.printf("%d, %d, %d", small, mid, big);
        } else {
            // outputs error message
            System.out.println("ERROR: No zero nor negative numbers allowed.");
        }
    }
}
