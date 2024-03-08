import java.util.Scanner;

public class BASIC009 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTests = scanner.nextInt();
        for (int i = 0; i < numTests; i++) {
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            System.out.println(quadrant(x, y));
        }
        scanner.close();
    }

    public static int quadrant(double x, double y) {
        if (x == 0 || y == 0) {
            return 0;
        } else if (x > 0 && y > 0) {
            return 1;
        } else if (x < 0 && y > 0) {
            return 2;
        } else if (x < 0 && y < 0) {
            return 3;
        } else {
            return 4;
        }
    }
}
