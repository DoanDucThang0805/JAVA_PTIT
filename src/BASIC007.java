import java.util.Scanner;

public class BASIC007 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTests = scanner.nextInt();
        for (int i = 0; i < numTests; i++) {
            int year = scanner.nextInt();
            if (isLeapYear(year)) {
                System.out.println(year + " : Leap-year");
            } else {
                System.out.println(year + " : Non Leap-year");
            }
        }
        scanner.close();
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}

