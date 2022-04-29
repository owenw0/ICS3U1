import java.util.*;

/*
    SoundAlarm
    Owen Wang
    Last modified: 2022-04-29
    Alarm!
*/
public class SoundAlarm {
    static void alarm(int x) {
        if (x < 1) {
            System.out.println("ERROR: Input less than 1.");
        } else {
            for (int i = 0; i < x; i++)
                System.out.println("Alarm!");
        }
    }

    public static void main(String[] args) {
    }
}
