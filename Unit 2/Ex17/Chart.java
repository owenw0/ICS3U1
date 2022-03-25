import java.util.*;

/*
    Chart
    Owen Wang
    Last modified: 2022-03-25
    Outputs chart of squares and cubes of nums 5-40.
*/
public class Chart {
    public static void main(String[] args) {
        // Output chart titles
        System.out.println("Number    Squared    Cubed");

        // loop through numbers and print squared and cubed value
        for (int i = 5; i <= 40; i++) {
            System.out.printf("%,-6d    %,-7.0f    %,.0f\n", i, Math.pow(i, 2), Math.pow(i, 3));
        }
    }
}
