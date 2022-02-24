import java.util.*;

/*
    TimeConversoin
    Owen Wang
    Last modified: 2022-02-24

    Obtains minutes and converts to hours and minutes.
*/
public class TimeConversion {
    public static void main(String[] args) {
        int min, hrs;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter minutes: ");
        min = input.nextInt();

        hrs = min / 60;
        min -= hrs * 60;

        System.out.printf("Hour:Minute format: %d:%02d\n", hrs, min);
    }
}
