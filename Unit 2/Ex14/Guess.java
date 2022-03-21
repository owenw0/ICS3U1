import java.util.*;

/*
    Guess
    Owen Wang
    Last modified: 2022-03-21

    User guesses number until correct or invalid number.
*/
public class Guess {
    public static void main(String[] args) {
        // variable declaration
        final int ANS = 2;
        int guess;
        Scanner sc = new Scanner(System.in);

        // loop
        do {
            System.out.print("Enter guess: ");
            guess = sc.nextInt();
        } while (guess != ANS && guess > 1 && guess < 20);

        if (guess == ANS) {
            System.out.println("Correct guess!");
        } else {
            System.out.println("Guess out of range.");
        }
    }
}
