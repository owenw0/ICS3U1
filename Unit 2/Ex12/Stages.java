import java.util.*;

/*
    Stages
    Owen Wang
    Last modified: 2022-03-10

    Outputs stage of life given age.
*/
public class Stages {
    public static void main(String[] args) {
        // variable declaration
        int age;
        Scanner sc = new Scanner(System.in);

        // prompts for age
        System.out.print("Enter age: ");
        age = sc.nextInt();

        // determines stage of life
        if (age > 18) {
            System.out.println("adult");
        } else if (age <= 18) {
            if (age <= 5) {
                System.out.println("toddler");
            } else if (age <= 10) {
                System.out.println("child");
            } else if (age <= 12) {
                System.out.println("preteen");
            } else {
                System.out.println("teen");
            }
        }
    }
}
