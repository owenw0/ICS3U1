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
        String file, name, line = "";
        double total = 0;
        double player_total = 0, num_entries = 0, num_players = 0;
        Scanner sc = new Scanner(System.in);

        // prompt for name
        System.out.print("Please enter the name of the team captain: ");
        file = sc.nextLine() + ".txt";
        System.out.printf("Opening %s\n", file);

        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            name = in.readLine();
            while (line != null) {
                try {
                    while (line != null) {
                        line = in.readLine();
                        player_total += Double.parseDouble(line);
                        num_entries++;
                    }
                } catch (IOException e) {
                    System.out.println(e);
                } catch (NumberFormatException e) {
                    // player name line has been reached
                    System.out.println(name);
                    name = line;
                    System.out.printf("%s average score: %.2f\n", name, player_total / num_entries);
                    num_players++;
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        System.out.printf("Team average: %.2f", player_total / num_players);
    }
}
