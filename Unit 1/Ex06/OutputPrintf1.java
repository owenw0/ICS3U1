import java.util.*;

/*
    OutputPrintf1
    Owen Wang
    Last modified: 2022-02-22

    Outputs Juanita's and Juan's bank account balance.
*/
public class OutputPrintf1 {
    public static void main(String[] args) {
        System.out.printf("%10s's bank account balance is $%,12.2f.\n", "Juanita", 2345678.99);
        System.out.printf("%10s's bank account balance is $%,12.2f.\n", "Juan", 15455.26);
    }
}