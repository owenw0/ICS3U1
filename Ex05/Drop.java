import java.util.*;

/*
    Drop
    Owen Wang
    Last modified: 2022-02-15

    Asks for time under 4.5 seconds and outputs height of object when dropped from 100 m.
*/
public class Drop {
    public static void main(String[] args) {
        double t;
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a time less than 4.5 seconds: ");
        t = input.nextDouble();
        System.out.println(100 - (4.9 * Math.pow(t, 2)));
    }
}
