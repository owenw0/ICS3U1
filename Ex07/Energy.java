import java.util.*;

/*
    Energy
    Owen Wang
    Last modified: 2022-02-24

    Outputs potential lightbubs powered given mass.
*/
public class Energy {
    public static void main(String[] args) {
        double e, m, c;
        Scanner input = new Scanner(System.in);

        c = 3.0 * Math.pow(10, 8);

        System.out.print("Enter mass (kg): ");
        m = input.nextDouble();
        e = m * Math.pow(c, 2);

        System.out.printf("Energy: %g J\n", e);
        System.out.printf("Can power: %,.0g lightbulbs", e / 360000);
    }
}