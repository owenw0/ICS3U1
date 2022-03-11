import java.util.*;

/*
    Tip
    Owen Wang
    Last modified: 2022-03-10

    Prompts for grade and outputs study tip.
*/
public class Tip {
    public static void main(String[] args) {
        // variable declaration
        char grade;
        Scanner sc = new Scanner(System.in);

        // prompt for grade
        System.out.print("Enter grade: ");
        grade = sc.next().charAt(0);

        // determine tip to output
        switch (grade) {
            case 'A', 'a':
                System.out.printf("Average. You can do better.\n");
                break;
            case 'B', 'b':
                System.out.printf("Below average. Work harder.\n");
                break;
            case 'C', 'c':
                System.out.println("Can't eat dinner. You're a failure.\n");
                break;
            case 'D', 'd':
                System.out.println("Don't come home. Until you score higher.\n");
                break;
            case 'F', 'f':
                System.out.println("Find a new family. We don't want you.\n");
                break;
            default:
                System.out.println("Invalid grade\n");
        }

    }
}
