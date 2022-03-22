import java.util.*;

/*
    Unicode
    Owen Wang
    Last modified: 2022-03-22

*/
public class Main {
  public static void main(String[] args) {
      // variable declaration
      int x = 1;

      // print headers
      System.out.println("Unicode    Character");
      
      // loop
      while (x <= 212) {
          System.out.printf("%-6d     %c\n", x, x);
          x++;
      }
  }
}