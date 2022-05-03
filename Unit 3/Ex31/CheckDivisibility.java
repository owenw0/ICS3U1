import java.util.*;

/*
    CheckDivisibility
    Owen Wang
    Last modified: 2022-04-29
    Check if integers can be divided.
*/
public class CheckDivisibility {
    /*
     * boolean evenlyDivisible(int x, int y)
     * returns boolean - if nums are evenly divisible
     * int x, int y - two ints to divide
     * This method takes in two integers and returns True if divisible.
     */
    static boolean evenlyDivisible(int x, int y) {
        if (x == 0 || y == 0) {
            return false;
        } else {
            return x % y == 0 || y % x == 0;
        }
    }

    public static void main(String[] args) {
    }
}
