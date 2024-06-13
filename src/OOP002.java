import java.util.Scanner;

public class OOP002 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after reading the integer
        for (int i = 0; i < testCases; i++) {
            String[] params = scanner.nextLine().split(" ");
            int x = Integer.parseInt(params[0]);
            int y = Integer.parseInt(params[1]);
            int width = Integer.parseInt(params[2]);
            int height = Integer.parseInt(params[3]);

            Rectangle rectangle = new Rectangle(x, y, width, height);
            System.out.println(rectangle);
        }
        scanner.close();
    }
}


class Rectangle {
    private final int x;
    private final int y;
    private final int width;
    private final int height;


    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }


    @Override
    public String toString() {
        return String.format("Rectangle[x=%d,y=%d,width=%d,height=%d]", x, y, width, height);
    }
}

