import java.util.*;

/*
    Backward1
    Owen Wang
    Last modified: 2022-03-25
    Counts down from 100 to 5 by 5.
*/
public class Backward1 {
    public static void main(String[] args) {
        // loop
        for (int i = 100; i >= 5; i -= 5) {
            System.out.println(i);
        }
    }
}