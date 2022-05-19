import java.util.*;
import java.io.*;

/*
    TeamCalculator
    Owen Wang
    Last modified: 2022-05-19
    Track gaming league scores.
*/
public class TeamCalculator {
    public static void main(String[] args) {
        // variable declaration
        String file, line = "";
        double total = 0;
        double player_total = 0, num_entries = 0, num_players = 0;
        Scanner sc = new Scanner(System.in);

        // prompt for name
        System.out.print("Please enter the name of the team captain: ");
        file = sc.nextLine() + ".txt";
        System.out.printf("Opening %s", file);

        try {
            BufferedReader in = new BufferedReader(new FileReader(file))
            name = in.readLine();
            while (line != null) {
                try {
                    while (line != null) {
                        line = in.readLine();
                        player_total += Double.parseDouble(line);
                        
                    }
                }
            }
        }
    }
}
