import java.util.*;

/*
    Driving
    Owen Wang
    Last modified: 2022-03-08

    Prompts for age and determines if eligible to drive.
*/
public class Driving {
    public static void main(String[] args) {
        // variable declaration
        int age;
        Scanner sc = new Scanner(System.in);

        // prompts user for age
        System.out.print("Enter age: ");
        age = sc.nextInt();

        // determines driving eligibility
        if (age < 18) {
            System.out.println("Too young to drive");
        } else if (age > 75) {
            System.out.println("Sorry you are over the legal age limit for driving");
        } else {
            System.out.println("Age OK. Have you got a driver's liscense?");
        }
    }
}
