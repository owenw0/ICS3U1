import java.util.*;

/*
    TwoLargest
    Owen Wang
    Last modified: 2022-04-06
    Outputs two largest ints in random array.
*/
public class TwoLargest {
    public static void main(String[] args) {
        // variable declaration
        int[] rand = new int[10];
        int max = 0;
        int max2 = 0;
        Random random = new Random();

        // fill array with random numbers
        for (int i = 0; i < rand.length; i++) {
            rand[i] = random.nextInt(100);
        }

        // search for max
        for (int i = 0; i < rand.length; i++) {
            if (rand[i] > max) {
                max2 = max;
                max = rand[i];
            } else if (rand[i] > max2) {
                max2 = rand[i];
            }
        }
        System.out.println(max);
        System.out.println(max2);
    }
}
