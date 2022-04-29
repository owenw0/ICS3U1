import java.util.*;

/*
    CalculateSum
    Owen Wang
    Last modified: 2022-04-29
    Sum of integers in range.
*/
public class CalculateSum {
    static int sumRange(int x, int y) {
        int sum = 0;
        if (y < x) {
            System.out.println("ERROR: Range invalid.");
        } else {
            for (int i = x; i <= y; i++) {
                sum += i;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
    }
}
