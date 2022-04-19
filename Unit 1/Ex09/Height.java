import java.util.*;

/*
    Height
    Owen Wang
    Last modified: 2022-02-28

    Obtains height in inches and outputs height in centimeters.
*/
public class Height {
    public static void main(String[] args) {
        double height;
        final double CONVERSION = 2.54;
        Scanner in = new Scanner(System.in);

        System.out.print("Enter height (in): ");
        height = in.nextDouble();
        System.out.printf("Height in cm: %.2f cm\n", height * CONVERSION);
    }
}
