import java.util.*;

/*
    Paper
    Owen Wang
    Last modified: 2022-03-25
    Determines height and area of paper after stacked and cut 40 times.
*/
public class Paper {
    public static void main(String[] args) {
        // variable declaration
        double height = 0.09, area = 1;

        // loop through cutting/stacking of paper
        for (int i = 0; i < 40; i++) {
            height *= 2;
            area /= 2;
        }
        System.out.printf("Height after 40 stacks: %,.2f m\n", height / 1000);
        System.out.printf("Area after 40 cuts: %,f m2\n", area);
    }
}
