import java.util.*;

/*
    Delivery
    Owen Wang
    Last modified: 2022-03-10

    Prompts for package dimensions and prints message.
*/
public class Delivery {
    public static void main(String[] args) throws Exception {
        // variable declaration
        double weight, length, width, height, size;
        final int WEIGHT_THRESHOLD = 27, SIZE_THRESHOLD = 100000;
        final double SEC1 = 3.00, SEC2 = 3.50, SEC3 = 4.00, SEC4 = 4.50;
        Scanner sc = new Scanner(System.in);

        // prompts for weight and dimensions
        System.out.print("Enter weight (kg): ");
        weight = sc.nextDouble();
        System.out.print("Enter length (cm): ");
        length = sc.nextDouble();
        System.out.print("Enter width (cm): ");
        width = sc.nextDouble();
        System.out.print("Enter height (cm): ");
        height = sc.nextDouble();

        size = length * width * height; // determines size

        // determines if package is eligible;
        if (weight <= WEIGHT_THRESHOLD && size <= SIZE_THRESHOLD) {
            if (weight <= 5) {
                System.out.printf("Price: $%,.2f\n", weight * SEC1);
            } else if (weight <= 12) {
                System.out.printf("Price: $%,.2f\n", weight * SEC2);
            } else if (weight <= 20) {
                System.out.printf("Price: $%,.2f\n", weight * SEC3);
            } else if (weight <= WEIGHT_THRESHOLD) {
                System.out.printf("Price: $%,.2f\n", weight * SEC4);
            }
        } else {
            // prints error message
            System.out.printf("\nMAX WEIGHT: %,d kg\n", WEIGHT_THRESHOLD);
            System.out.printf("MAX SIZE: %,d cubic cm\n", SIZE_THRESHOLD);
        }
    }
}
