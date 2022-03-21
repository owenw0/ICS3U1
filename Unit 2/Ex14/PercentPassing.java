import java.util.*;

/*
    PercentPassing
    Owen Wang
    Last modified: 2022-03-21

    Outputs percentage of scores above 70%.
*/
public class PercentPassing {
    public static void main(String[] args) {
        // variable declaration
        double score = 0, passing = 0, total = 0;
        Scanner sc = new Scanner(System.in);

        // loop
        while (true) {
            System.out.print("Enter score (%): ");
            score = sc.nextDouble();
            if (score < 0) {
                break;
            }
            total++;
            if (score > 70) {
                passing++;
            }
        }
        System.out.printf("Percentage of scores above 70%%: %d%%", (int) ((passing / total) * 100));
    }
}
