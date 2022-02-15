import java.util.*;

/*
    Input_3
    Owen Wang
    Last modified: 2022-02-15

    Asks user for name and age and tells them their name and age
*/
public class Input_3 {
    public static void main(String[] args) {
        String name;
        int age;
        Scanner input = new Scanner(System.in);

        System.out.print("What's your name? ");
        name = input.nextLine();
        System.out.print("How old are you? ");
        age = input.nextInt();

        System.out.println("So you are " + name + " and you are " + age);
    }
}
