import java.util.Scanner;

public class LAB01_ClassMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Đọc số lượng testcase
        int testcase = sc.nextInt();
        sc.nextLine();  // Đọc bỏ dòng xuống sau số testcase

        for (int i = 0; i < testcase; i++) {
            // Đọc từng câu
            String line = sc.nextLine();

            // Đếm số lượng ký tự (bao gồm cả khoảng trắng)
            int charCount = line.length();

            // Đếm số lượng từ (tách bởi khoảng trắng)
            String[] words = line.split("\\s+");
            int wordCount = words.length;

            // In kết quả
            System.out.println(charCount + " " + wordCount);
        }

        sc.close();
    }
}
