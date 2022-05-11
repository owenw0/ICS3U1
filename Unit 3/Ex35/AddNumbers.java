import java.util.*;
import java.io.*;

/*
    AddNumbers
    Owen Wang
    Last modified: 2022-05-09
    Read numbers from file and output sum.
*/
public class AddNumbers {
    public static void main(String[] args) {
        // variable declaration
        String fileName = "numbers.txt";
        int num, total = 0;
        try {
            Scanner fs = new Scanner(new File(fileName));
            while (true) {
                num = fs.nextInt();
                total += num;
            }
        } catch (InputMismatchException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        } catch (NoSuchElementException e) {
        }
        System.out.printf("Total sum: %d\n", total);
    }
}