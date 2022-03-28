import java.util.*;

/*
    SquareCube
    Owen Wang
    Last modified: 2022-03-28
    Adds up squares and cubes of ints from 1-n.
*/
public class SquareCube {
    public static void main(String[] args) {
        // variable declaration
        int n, total_squares = 0, total_cubes = 0;
        Scanner sc = new Scanner(System.in);

        // prompt for n
        System.out.println("Upper Limit:");
        n = sc.nextInt();

        // loop through cubes
        for (int i = 1; i <= n; i++) {
            total_squares += Math.pow(i, 2);
            total_cubes += Math.pow(i, 3);
        }
        System.out.printf("\nThe sum of Squares is %d\n", total_squares);
        System.out.printf("The sum of Cubes is %d", total_cubes);
    }
}
