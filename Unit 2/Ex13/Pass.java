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
        int int1, int2, op;
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        // generates random numbers from 1-20
        int1 = rand.nextInt(1, 21);
        int2 = rand.nextInt(1, 21);
        op = rand.nextInt(1, 5);

        // prompts user for answer to question
        switch (op) {
            case 1:
                System.out.printf("%d + %d = ", int1, int2);
                break;
            case 2:
                System.out.printf("%d - %d = ", int1, int2);
                break;
            case 3:
                System.out.printf("%d * %d = ", int1, int2);
                break;
            case 4:
                System.out.printf("%d / %d = ", int1, int2);
                break;
        }
        answer = sc.nextDouble();

        // determines pass or fail
        switch (op) {
            case 1:
                if (answer == int1 + int2) {
                    System.out.println("Pass");
                } else {
                    System.out.println("Fail");
                }
                break;
            case 2:
                if (answer == int1 - int2) {
                    System.out.println("Pass");
                } else {
                    System.out.println("Fail");
                }
                break;
            case 3:
                if (answer == int1 * int2) {
                    System.out.println("Pass");
                } else {
                    System.out.println("Fail");
                }
                break;
            case 4:
                if (answer == (double) int1 / (double) int2) {
                    System.out.println("Pass");
                } else {
                    System.out.println("Fail");
                }
                break;
        }
    }
}
