import java.util.*;

/*
    Input4_
    Owen Wang
    Last modified: 2022-02-15

    Asks for two words, then outputs both of them in new lines then both in one line
*/
public class Input_4 {
    public static void main(String[] args) {
        String word1, word2;
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter word #1: ");
        word1 = input.nextLine();
        System.out.print("Please enter word #2: ");
        word2 = input.nextLine();

        System.out.println(word1);
        System.out.println(word2);
        System.out.println(word1 + "\t" + word2);
    }
}
