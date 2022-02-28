import java.util.*;

/*
    Cost
    Owen Wang
    Last modified: 2022-02-28

    Asks for price of item and # bags used then outputs total cost.
*/
public class Cost {
    public static void main(String[] args) {
        double cost, total;
        int bags;
        final double HST = 1.13;
        Scanner in = new Scanner(System.in);

        System.out.print("Enter price: $");
        cost = in.nextDouble();

        System.out.print("Enter # bags used: ");
        bags = in.nextInt();

        total = (cost + bags * 0.05) * HST;
        System.out.printf("Total: $%,.2f", total);
    }
}