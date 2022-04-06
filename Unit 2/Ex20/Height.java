import java.util.*;

/*
    Height
    Owen Wang
    Last modified: 2022-04-06
    Read heights and outputs higher than avg heights.
*/
public class Height {
    public static void main(String[] args) {
        // variable declaration
        int heights[] = { 100, 105, 110, 115, 120, 125, 130, 135, 140, 145, 150, 155, 160, 165, 170, 175, 180, 185, 190,
                200 };
        double avg = Arrays.stream(heights).sum() / heights.length;

        // loop through heights
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] > avg) {
                System.out.println(heights[i]);
            }
        }
    }
}