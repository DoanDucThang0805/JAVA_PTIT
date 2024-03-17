import java.util.Scanner;


public class OOP009 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < testcase; i++){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            sc.nextLine();
            Point point1 = new Point(x1, y1);
            Point point2 = new Point(x2, y2);
            double slope = point1.slope(point2);
            System.out.println(slope);
        }
    }
}


class Point{
    int x, y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    public double slope(Point other){
        if (this.x == other.x) {
            return -1;
        } else if (this.y == other.y) {
            return 0;
        } else {
            return (double) (other.y - this.y) / (other.x - this.x);
        }
    }
}