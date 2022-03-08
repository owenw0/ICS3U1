import java.util.*;

/*
    Temperature
    Owen Wang
    Last modified: 2022-03-08

    Prompts for temperature (C) and prints a message.
*/
public class Temperature {
    public static void main(String[] args) {
        // variable declaration
        double temp;
        Scanner sc = new Scanner(System.in);

        // prompts user for temperature
        System.out.print("Enter temperature (C): ");
        temp = sc.nextDouble();

        // determines temperature and prints message
        if (temp < -18) {
            System.out.println("very cold");
        } else if (temp >= 100) {
            System.out.println("boiling point of water");
        } else if (temp >= -18 && temp <= 0) {
            System.out.println("cold");
        } else if (temp == 0) {
            System.out.println("freezing point of water");
        } else if (temp > 0 && temp <= 10) {
            System.out.println("very cool");
        } else if (temp > 10 && temp <= 20) {
            System.out.println("moderate");
        } else if (temp > 20 && temp <= 30) {
            System.out.println("warm");
        } else if (temp > 30 && temp <= 40) {
            System.out.println("hot");
        } else if (temp > 40 && temp < 100) {
            System.out.println("boiling point of water");
        }
    }
}
