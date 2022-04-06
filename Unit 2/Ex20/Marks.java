import java.util.*;

/*
    Marks
    Owen Wang
    Last modified: 2022-04-06
    Markbook of size 4.
*/
public class Marks {
    public static void main(String[] args) {
        // variable declaration
        String[] names = new String[4];
        String name;
        int[] marks = new int[4];
        int mark;
        int search;
        Scanner sc = new Scanner(System.in);

        // prompt for name and mark
        for (int i = 0; i < names.length; i++) {
            System.out.printf("Enter name %d: ", i + 1);
            name = sc.nextLine();
            System.out.printf("Enter %s's mark (%%): ", name);
            mark = sc.nextInt();
            sc.nextLine();
            names[i] = name;
            marks[i] = mark;
        }

        // prompt for mark search
        System.out.println("\nSearch for mark (%): ");
        search = sc.nextInt();

        // search array
        for (int i = 0; i < names.length; i++) {
            if (i == marks.length - 1 && marks[i] != search) {
                System.out.println("Mark does not exist.");
            }
            if (marks[i] == search) {
                System.out.printf("%s has obtained mark of %d", names[i], search);
                break;
            }
        }
    }
}
