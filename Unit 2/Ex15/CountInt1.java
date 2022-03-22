import java.util.*;

/*
    CountInt1
    Owen Wang
    Last modified: 2022-03-22
    Outputs number of integers entered.
*/
public class Main {
  public static void main(String[] args) {
      // variable declaration
      int num, total = 0;
      Scanner sc = new Scanner(System.in);

      // prompt for number
      System.out.print("Enter number: ");
      num = sc.nextInt();

      // loop
      while (num != -1) {
          total ++;
          System.out.print("Enter number: ");
          num = sc.nextInt();
      }
      System.out.printf("Number of integers entered: %d", total);
  }
}