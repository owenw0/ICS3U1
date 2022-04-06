import java.util.*;

/*
    SelfReverse
    Owen Wang
    Last modified: 2022-04-06

*/
public class SelfReverse {
    public static void main(String[] args) {
        // variable declaration
        int[] list = new int[10];
        int counter = 9, val;
        Scanner sc = new Scanner(System.in);

        // prompt user for input
        System.out.println("Enter 10 numbers:");
        for (int i = 0; i < 10; i++) {
            System.out.printf("Enter number %d: ", i + 1);
            list[i] = sc.nextInt();
        }

        // reverse list
        for (int i = 0; i < list.length; i++) {
            val = list[i];
            list[i] = list[counter];
            list[counter] = val;
            counter--;
        }
    }
}
