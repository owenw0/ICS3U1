import java.util.*;
import java.io.*;

/*
    TimeTable
    Owen Wang
    Last modified: 2022-05-12
    Writes times table to file.
*/
public class TimeTable {
    public static void main(String[] args) {
        // variable declaration
        String file = "timetable.txt";

        // write to file
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(file, false));
            out.write("    ");
            for (int i = 1; i <= 12; i++) {
                if (i < 10) {
                    out.write(i + "   ");
                } else if (i < 100) {
                    out.write(i + "  ");
                } else {
                    out.write(i + " ");
                }
            }
            out.newLine();

            for (int i = 1; i <= 12; i++) {
                if (i < 10) {
                    out.write(i + "   ");
                } else if (i < 100) {
                    out.write(i + "  ");
                } else {
                    out.write(i + " ");
                }
                for (int j = 1; j <= 12; j++) {
                    if (j * i < 10) {
                        out.write(j * i + "   ");
                    } else if (j * i < 100) {
                        out.write(j * i + "  ");
                    } else {
                        out.write(j * i + " ");
                    }
                }
                out.newLine();
            }
            out.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
