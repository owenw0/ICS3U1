import java.util.*;
import java.io.*;

/*
    ReverseLines
    Owen Wang
    Last modified: 2022-05-11
    Read lines and output reversed.
*/
public class ReverseLines {
    public static void main(String[] args) {
        // variable declaration
        String file = "reverse.txt";
        String input;
        int len;
        String[] s;

        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            input = in.readLine();
            len = Integer.parseInt(input);
            s = new String[len];
            for (int i = 0; i < len; i++) {
                s[i] = in.readLine();
            }
            for (int i = s.length - 1; i >= 0; i--) {
                System.out.println(s[i]);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
