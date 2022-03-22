import java.util.*;

/*
    Sum
    Owen Wang
    Last modified: 2022-03-22
    Outputs sum of numbers given.
*/
public class Main {
  public static void main(String[] args) {
      // variable declaration
      int num, sum = 0;
      Scanner sc = new Scanner(System.in);

      // prompt for number
      System.out.print("Enter number: ");
      num = sc.nextInt();

      // loop
      while (num > 0) {
          sum += num;
          System.out.print("Enter number: ");
          num = sc.nextInt();
      }
      System.out.printf("Sum: %d", sum);
  }
}