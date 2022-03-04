import java.util.*;

/*
    FenceEstimate
    Owen Wang
    Last modified: 2022-03-04

    Estimate quote for building fence.
*/
public class FenceEstimate {
    public static void main(String[] args) {
        double height, width, perimeter;
        final double wire_fence = 24.49, wooden_fence = 89.99;
        Scanner in = new Scanner(System.in);

        System.out.print("Enter lawn length in meters:   ");
        height = in.nextDouble();
        System.out.print("Enter lawn width in meters:    ");
        width = in.nextDouble();

        perimeter = height * 2 + width * 2;
        System.out.format("\nTotal perimeter:  %.1f m\n", height * 2 + width * 2);
        System.out.format("\nFence type:%19s\n", "Estimate:");
        System.out.println("==============================");
        System.out.format("Wire Fence            $%7.2f\n", perimeter * wire_fence);
        System.out.format("Wooden Fence          $%7.2f\n", perimeter * wooden_fence);
    }
}
