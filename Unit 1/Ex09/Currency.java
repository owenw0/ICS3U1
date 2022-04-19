import java.util.*;

/*
    Currency
    Owen Wang
    Last modified: 2022-02-28

    Converts USD to CAD.
*/
public class Currency {
    public static void main(String[] args) {
        double usd;
        final double CONVERSION = 1.29;
        Scanner in = new Scanner(System.in);

        System.out.print("Enter USD amount: $");
        usd = in.nextDouble();

        System.out.printf("CAD Amount: $%,.2f\n", usd * CONVERSION);
    }
}