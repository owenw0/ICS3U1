import java.util.*;

/*
    OutputPrintf2
    Owen Wang
    Last modified: 2022-02-22

    Output number and its square in a table.
*/
public class OutputPrintf2 {
    public static void main(String[] args) {
        System.out.printf("%-9s%8s\n", "Number", "Square");
        System.out.printf("%-9.2f%8.5f\n", 1.10, Math.pow(1.10, 2));
        System.out.printf("%-9.2f%8.5f\n", 1.11, Math.pow(1.11, 2));
        System.out.printf("%-9.2f%8.5f\n", 1.12, Math.pow(1.12, 2));
        System.out.printf("%-9.2f%8.5f\n", 1.13, Math.pow(1.13, 2));
        System.out.printf("%-9.2f%8.5f\n", 1.14, Math.pow(1.14, 2));
        System.out.printf("%-9.2f%8.5f\n", 1.15, Math.pow(1.15, 2));
    }
}
