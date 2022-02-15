import java.util.*;

/*
    Input_2
    Owen Wang
    Last modified: 2022-02-15

    Asks user for name then says hello
*/
public class Input_2 {
    public static void main(String[] args) {
        String name;
        Scanner input = new Scanner(System.in);

        System.out.print("What's your name? ");
        name = input.nextLine();

        System.out.println("Hello " + name);
    }
}
