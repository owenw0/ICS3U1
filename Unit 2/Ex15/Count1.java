import java.util.*;

/*
    Count1
    Owen Wang
    Last modified: 2022-03-22
    Counts down from 100 to 1 by 2.
*/
public class Main {
  public static void main(String[] args) {
      // variable declaration
      int x = 100;

      // loop
      do {
          System.out.println(x);
          x -= 2;
      } while (x >= 1);
  }
}