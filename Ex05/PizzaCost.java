import java.util.*;

/*
    PizzaCost
    Owen Wang
    Last modified: 2022-02-15

    Asks user for pizza diameter and gives total cost of pizza
*/
public class PizzaCost {
    public static void main(String[] args) {
        double size;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter pizza diameter \": ");
        size = input.nextDouble();
        double cost = 1.75 + (0.05 * Math.pow(size, 2));
        System.out.format("Total cost: $%.2f", cost);
    }
}
