import java.util.*;

/*
    Pass
    Owen Wang
    Last modified: 2022-03-08

    Asks user to input math answer and outputs if correct or not.
*/
public class Pass {
    public static void main(String[] args) {
        double answer;
        Scanner sc = new Scanner(System.in);

        // Asks user what 1 + 1 is
        System.out.print("1 + 1 = ");
        answer = sc.nextDouble();

        // prompts user for answer
        if (answer == 2) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }
}
