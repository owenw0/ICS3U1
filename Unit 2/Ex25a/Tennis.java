import java.util.*;

/*
    Tennis
    Owen Wang
    Last modified: 2022-04-14
    Set of tennis scores and wins.
*/
public class Tennis {
    public static void main(String[] args) {
        // variable declaration
        final int SIZE = 5;
        int[] player1 = new int[SIZE];
        int[] player2 = new int[SIZE];
        int p1Wins = 0, p2Wins = 0;
        Scanner sc = new Scanner(System.in);

        // prompt user for scores
        for (int i = 0; i < SIZE; i++) {
            System.out.printf("Enter Player 1's score for set %d: ", i + 1);
            player1[i] = sc.nextInt();
            System.out.printf("Enter Player 2's score for set %d: ", i + 1);
            player2[i] = sc.nextInt();
        }

        // determine games won by each player
        for (int i = 0; i < SIZE; i++) {
            if (player1[i] == 6) {
                p1Wins++;
            } else {
                p2Wins++;
            }
        }

        // output total number games won by each player
        System.out.printf("Player 1 won %d games.\n", p1Wins);
        System.out.printf("Player 2 won %d games.\n", p2Wins);
    }
}
