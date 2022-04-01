import java.util.*;

/*
    TriangleOfNumbers
    Owen Wang
    Last modified: 2022-04-01
    Prints a triangle of numbers.
*/
public class TriangleOfNumbers {
    public static void main(String[] args) {
        // loop through nums
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
