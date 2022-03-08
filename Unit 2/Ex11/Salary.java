import java.util.*;

/*
    Salary
    Owen Wang
    Last modified: 2022-03-08

    Prompts for # of sales and determines total salary.
*/
public class Salary {
    public static void main(String[] args) {
        // variable declaration
        int sales;
        double salary = 1000;
        Scanner sc = new Scanner(System.in);

        // prompts user for sales made
        System.out.print("Enter # of sales made: ");
        sales = sc.nextInt();

        // determines salary based on sales
        if (sales >= 10) {
            salary += salary * (double) sales / 100;
        }

        System.out.printf("Salary: $%,.2f", salary); // outputs salary
    }
}
