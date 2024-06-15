import java.util.Scanner;

public class BASIC010 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Đọc số lượng test case
        int testCaseCount = scanner.nextInt();

        for (int i = 0; i < testCaseCount; i++) {
            int number = scanner.nextInt();
            int swappedNumber = swapDigitPairs(number);
            System.out.println(swappedNumber);
        }

        scanner.close();
    }

    public static int swapDigitPairs(int n) {
        int result = 0;
        int multiplier = 1;

        while (n >= 10) {
            int lastDigit = n % 10;
            int secondLastDigit = (n / 10) % 10;

            result += (lastDigit * 10 + secondLastDigit) * multiplier;

            n /= 100;
            multiplier *= 100;
        }

        // Nếu còn lại một chữ số lẻ
        if (n > 0) {
            result += n * multiplier;
        }

        return result;
    }
}
