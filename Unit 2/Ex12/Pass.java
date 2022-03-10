import java.util.*;

/*
    Pass
    Owen Wang
    Last modified: 2022-03-10

    Asks user to input math answer and outputs if correct or not.
*/
public class Pass {
    public static void main(String[] args) {
        // variable declaration
        double answer;
        int int1, int2;
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        // generates random numbers from 1-20
        int1 = rand.nextInt(1, 20);
        int2 = rand.nextInt(1, 20);

        // prompts user for answer to 1 + 1
        System.out.printf("%d + %d = ", int1, int2);
        answer = sc.nextDouble();

        // determines pass or fail
        if (answer == int1 + int2) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }
}
