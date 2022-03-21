import java.util.*;

/*
    Age
    Owen Wang
    Last modified: 2022-03-21

    User guesses age until correct.
*/
public class Age {
    public static void main(String[] args) {
        // variable declaration
        final int AGE = 16;
        int guess;
        Scanner sc = new Scanner(System.in);

        // loop
        do {
            System.out.print("Enter guess: ");
            guess = sc.nextInt();
        } while (guess != AGE);

        System.out.println("Correct!");
    }
}
