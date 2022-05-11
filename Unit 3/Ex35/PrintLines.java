import java.util.*;
import java.io.*;

/*
    PrintLines
    Owen Wang
    Last modified: 2022-05-09
    Read lines and output them.
*/
public class PrintLines {
    public static void main(String[] args) {
        // varable declaration
        String file = "line.txt";
        String line;
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            line = in.readLine();
            while (line != null) {
                System.out.println(line);
                line = in.readLine();
            }
        } catch (InputMismatchException e) {
            System.out.println("\nNon-string data detected. File read terminated.");
        } catch (IOException e) {
            System.out.println(e + "  Problem reading " + file);
        }
    }
}