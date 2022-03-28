import java.util.*;

/*
    Alphabets
    Owen Wang
    Last modified: 2022-03-28
    Asks for alphabet letter until non-letter entered.
*/
public class Alphabets {
    public static void main(String[] args) {
        // variable declaration
        char in;
        int upper = 0, lower = 0, vowel = 0;
        char vowels[] = { 'A', 'a', 'E', 'e', 'I', 'i', 'O', 'o', 'U', 'u', 'Y', 'y' };
        Scanner sc = new Scanner(System.in);

        // keep prompting user for letter until non letter inputted
        do {
            System.out.print("Enter an alphabet: ");
            in = sc.next().charAt(0);
            for (int i : vowels) {
                if (in == vowels[i]) {
                    vowel++;
                }
            }
            if (in >= 65 && in <= 90) {
                lower++;
            } else if (in >= 97 && in <= 122) {
                upper++;
            }
        } while ((in >= 65 && in <= 90) || (in >= 97 && in <= 122));
        System.out.printf("\nYou have entered %,d upper case alphabets.\n", upper);
        System.out.printf("You have entered %,d lower case alphabets.\n", lower);
        System.out.printf("You have entered %,d vowels.", vowel);
    }
}
