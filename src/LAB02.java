import java.math.BigInteger;
import java.util.Scanner;

public class LAB02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Đọc dòng đầu tiên là một số nguyên
        BigInteger number1 = new BigInteger(scanner.nextLine().trim());

        // Đọc dòng thứ hai và chỉ lấy số nguyên từ chuỗi "Integer = "
        String line2 = scanner.nextLine().trim();
        BigInteger number2 = extractNumber(line2);

        // So sánh giá trị
        boolean isEqual = number1.equals(number2);

        // In kết quả
        System.out.println(isEqual);

        scanner.close();
    }

    // Phương thức để lấy số nguyên từ chuỗi
    private static BigInteger extractNumber(String str) {
        // Loại bỏ các ký tự không phải là số
        StringBuilder sb = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (Character.isDigit(ch)) {
                sb.append(ch);
            }
        }
        // Chuyển đổi chuỗi thành số nguyên
        return new BigInteger(sb.toString());
    }
}
