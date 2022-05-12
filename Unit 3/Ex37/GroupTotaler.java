import java.util.*;
import java.io.*;

/*
    GroupTotaler
    Owen Wang
    Last modified: 2022-05-12
    Outputs sum of numbers in each group.
*/
public class GroupTotaler {
    public static void main(String[] args) {
        // variable declaration
        String file = "input.txt";
        String name = "";
        String line = "";
        int total = 0;
        BufferedReader in;

        try {
            in = new BufferedReader(new FileReader(file));
            name = in.readLine();
            while (line != null) {
                try {
                    while (line != null) {
                        line = in.readLine();
                        total += Integer.parseInt(line);
                    }
                } catch (IOException e) {
                    System.out.println(e);
                } catch (NumberFormatException e) {
                    // group line has been reached
                    System.out.println(name);
                    name = line;
                    System.out.printf("Sum: %d\n\n", total);
                    total = 0;
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
