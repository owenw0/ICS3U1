import java.util.*;

/*
    Array1DOddEven
    Owen Wang
    Last modified: 2022-04-13
    Outputs even/odd status of array.
*/
public class Array1DOddEven {
    public static void main(String[] args) {
        // variable declaration
        final int LEN = 3;
        int status;
        boolean error = false;
        int[] arr = new int[LEN];
        Scanner sc = new Scanner(System.in);

        // prompt for integers
        for (int i = 0; i < LEN; i++) {
            System.out.print("Enter integer: ");
            arr[i] = sc.nextInt();
        }

        // loop through array
        if (arr[0] % 2 == 0) {
            status = 0;
        } else {
            status = 1;
        }
        for (int i = 1; i < LEN; i++) {
            if (arr[i] % 2 != status) {
                error = true;
                break;
            }
        }
        if (error) {
            System.out.println("Array not all even/odd.");
        } else {
            System.out.println("Array all even/odd");
        }
    }
}
