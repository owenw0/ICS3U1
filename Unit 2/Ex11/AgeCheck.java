import java.util.*;

/*
    AgeCheck
    Owen Wang
    Last modified: 2022-03-08

    Outputs eligibility to vote or years until eligible.
*/
public class AgeCheck {
    public static void main(String[] args) {
        int age;
        Scanner sc = new Scanner(System.in);

        // prompts user for age
        System.out.print("Enter age (yr): ");
        age = sc.nextInt();

        // determines if user is eligible to vote
        if (age >= 18) {
            System.out.println("OLD ENOUGH TO VOTE");
        } else {
            System.out.printf("%d years until you can vote", 18 - age);
        }
    }
}
