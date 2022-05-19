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
                        // add up player points
                        line = in.readLine();
                        player_total += Double.parseDouble(line);
                        num_entries++;
                    }
                } catch (IOException e) {
                    System.out.println(e);
                } catch (NumberFormatException e) {
                    // player name reached, output average and reset variables
                    System.out.print(name);
                    name = line;
                    System.out.printf(" average score: %.2f\n", player_total / num_entries);
                    total += player_total / num_entries;
                    num_players++;
                    player_total = 0;
                    num_entries = 0;
                } catch (NullPointerException e) {
                    System.out.println(e);
                }
            }
            in.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        // output team average
        System.out.printf("Team average: %.2f\n", total / num_players);
    }
}