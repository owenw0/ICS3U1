import java.util.*;

/*
    ConvertDate
    Owen Wang
    Last modified: 2022-03-10

    Converts numerical date value to formal output.
*/
public class ConvertDate {
    public static void main(String[] args) {
        // variable declaration
        int year, month, day;
        String str_month;
        Scanner sc = new Scanner(System.in);

        // prompt user for dates
        System.out.print("Enter year: ");
        year = sc.nextInt();
        System.out.print("Enter month: ");
        month = sc.nextInt();
        System.out.print("Enter day: ");
        day = sc.nextInt();

        // determine proper output
        switch (month) {
            case 1:
                System.out.printf("January %d, %d\n", day, year);
                break;

            case 2:
                System.out.printf("Febuary %d, %d\n", day, year);
                break;

            case 3:
                System.out.printf("March %d, %d\n", day, year);
                break;

            case 4:
                System.out.printf("April %d, %d\n", day, year);
                break;

            case 5:
                System.out.printf("May %d, %d\n", day, year);
                break;

            case 6:
                System.out.printf("June %d, %d\n", day, year);
                break;

            case 7:
                System.out.printf("July %d, %d\n", day, year);
                break;

            case 8:
                System.out.printf("August %d, %d\n", day, year);
                break;

            case 9:
                System.out.printf("September %d, %d\n", day, year);
                break;

            case 10:
                System.out.printf("October %d, %d\n", day, year);
                break;

            case 11:
                System.out.printf("November %d, %d\n", day, year);
                break;

            case 12:
                System.out.printf("December %d, %d\n", day, year);
                break;

            default:
                System.out.println("Invalid month");
        }
    }
}
