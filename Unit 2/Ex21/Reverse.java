import java.util.*;

/*
    Reverse
    Owen Wang
    Last modified: 2022-04-06
    Fills a list in reverse order of another list.   
*/
public class Reverse {
    public static void main(String[] args) {
        // variable declaration
        int[] list1 = new int[10];
        int[] list2 = new int[10];
        int counter = 9;
        Scanner sc = new Scanner(System.in);

        // prompt user for input
        System.out.println("Enter 10 numbers:");
        for (int i = 0; i < 10; i++) {
            System.out.printf("Enter number %d: ", i + 1);
            list1[i] = sc.nextInt();
        }

        // fill list2
        for (int i = 0; i < list2.length; i++) {
            list2[i] = list1[counter];
            counter--;
        }
    }
}
