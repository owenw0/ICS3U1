import java.util.*;

/*
    Capital
    Owen Wang
    Last modified: 2022-03-10

    Prompts for capital of Canada
*/
public class Capital {
    public static void main(String[] args) {
        // variable declaration
        String ans;
        Scanner sc = new Scanner(System.in);

        // prompts for capital of Canada
        System.out.print("Enter capital of Canada: ");
        ans = sc.nextLine();

        // determines if they are correct or not (DOES NOT WORK)
        if (ans.toLowerCase() == "ottawa") {
            System.out.println("Correct!");
        } else {
            System.out.println("Incorrect.");
        }
    }
}
