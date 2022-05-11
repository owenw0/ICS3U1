import java.util.*;
import java.io.*;

/*
    PrintAllChar
    Owen Wang
    Last modified: 2022-05-11
    Read chars and print every char on newline.
*/
public class PrintAllChar {
    public static void main(String[] args) {
        // variable declaration
        String file = "allChar.txt";
        int c;
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            c = in.read();
            while (c != -1) {
                System.out.println((char) c);
                c = in.read();
            }
            in.close();
        } catch (IOException e) {
            System.out.println(e);
        } catch (InputMismatchException e) {
            System.out.println(e);
        }
    }
}
