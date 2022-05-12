import java.util.*;
import java.io.*;

/*
    WriteChars
    Owen Wang
    Last modified: 2022-05-12
    Read input and output each char on newline.
*/
public class WriteChars {
    public static void main(String[] args) {
        // variable declaration
        String file = "writeChars.txt";
        char[] c;
        String line;
        Scanner sc = new Scanner(System.in);

        // ask for input and write to file
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(file, false));
            System.out.print("Enter line: ");
            line = sc.nextLine();
            c = new char[line.length()];

            // Copying character by character into array
            // using for each loop
            for (int i = 0; i < line.length(); i++) {
                c[i] = line.charAt(i);
            }
            for (int i = 0; i < c.length; i++) {
                out.write(c[i]);
                out.newLine();
            }
            out.close();
        } catch (IOException e) {
        }
    }
}
