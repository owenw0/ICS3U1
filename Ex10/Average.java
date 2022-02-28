import java.util.*;

/*
    Average
    Owen Wang
    Last modified: 2022-02-28

    Outputs average of 5 grades.
*/
public class Average {
    public static void main(String[] args) {
        int g1, g2, g3, g4, g5;
        double avg;
        Scanner in = new Scanner(System.in);

        System.out.print("Enter grade 1: ");
        g1 = in.nextInt();
        System.out.print("Enter grade 2: ");
        g2 = in.nextInt();
        System.out.print("Enter grade 3: ");
        g3 = in.nextInt();
        System.out.print("Enter grade 4: ");
        g4 = in.nextInt();
        System.out.print("Enter grade 5: ");
        g5 = in.nextInt();

        avg = (double) (g1 + g2 + g3 + g4 + g5) / 5;
        System.out.printf("Average grade is: %.2f%%.\n", avg);
    }

}
