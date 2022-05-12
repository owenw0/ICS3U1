import java.util.*;
import java.io.*;

/*
    WriteLines
    Owen Wang
    Last modified: 2022-05-09
    Read input and write to file.
*/
public class scratch {
    public static void main(String[] args) {
        // variable declaration
        String line, file = "scratch.txt";
        Scanner sc = new Scanner(System.in);

        // ask for input and write to file
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(file, false));
            for (int i = 0; i < 10; i++) {
                System.out.print("Enter: ");
                line = sc.nextLine();
                out.write(line);
                out.newLine();
            }
            out.close();
        } catch (IOException e) {
        }
    }
}
