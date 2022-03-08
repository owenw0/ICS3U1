import java.util.*;

/*
    Test
    Owen Wang
    Last modified: 2022-03-08

    Prompts teacher for test mark and outputs range and pass/fail.
*/
public class Test {
    public static void main(String[] args) {
        // variable declaration
        double mark;
        Scanner sc = new Scanner(System.in);

        // prompts user for mark
        System.out.print("Enter mark: ");
        mark = sc.nextDouble();

        // determines if mark is within range and passing/failing
        if (mark > 100) {
            System.out.println("ABOVE RANGE");
        } else if (mark < 0) {
            System.out.println("BELOW RANGE");
        } else if (mark >= 50) {
            System.out.println("Passing grade");
        } else {
            System.out.println("Failing grade");
        }
    }
}