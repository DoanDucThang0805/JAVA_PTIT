import java.util.Scanner;

public class BASIC011 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Đọc dòng trống sau khi đọc số lượng test cases

        for (int t = 0; t < testCases; t++) {
            String[] numbers = scanner.nextLine().split(" ");
            int[] arr = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                arr[i] = Integer.parseInt(numbers[i]);
            }
            System.out.println(minGap(arr));
        }
        scanner.close();
    }

    static int minGap(int[] arr) {
        if (arr.length < 2) {
            return 0; // Trường hợp mảng có ít hơn 2 phần tử
        }

        int minDifference = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            int difference = arr[i + 1] - arr[i];
            if (difference < minDifference) {
                minDifference = difference;
            }
        }
        return minDifference;
    }
}
