import java.util.*;

/*
    Average
    Owen Wang
    Last modified: 2022-02-15

    Asks for three double values then outputs average.
*/
public class Average {
    public static void main(String[] args) {
        double x, y, z;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter double value: ");
        x = input.nextDouble();
        System.out.print("Enter double value: ");
        y = input.nextDouble();
        System.out.print("Enter double value: ");
        z = input.nextDouble();
        System.out.println((x + y + z) / 3);
    }
}
