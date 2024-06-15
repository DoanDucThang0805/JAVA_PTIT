import java.util.*;
import java.math.*;

public class ELAB2313 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Point> points = new ArrayList<>();
        try {
            while (sc.hasNextLine()) {
                String name = sc.nextLine();
                try {
                    String[] inputs = sc.nextLine().split("\\s+");
                    double x = Double.parseDouble(inputs[0]);
                    double y = Double.parseDouble(inputs[1]);
                    double z = Double.parseDouble(inputs[2]);
                    points.add(new Point(name, x, y, z));
                }catch (Exception e){
                    Point point_1 = find_point(name, points);
                    if (point_1.name.equals("False")){
                        throw new Exception();
                    }
                    for (Point point : points){
                        if(point.name.equals(name)) continue;
                        System.out.println(new Line(point_1, point));
                    }
                }
            }
        }catch (Exception e){
            System.out.println("invalid input");
        }
    }


    public static Point find_point(String name, ArrayList<Point> points) {
        for (Point point : points) {
            if (point.name.equals(name)) {
                return point;
            }
        }
        return new Point("False", 0, 0, 0);
    }
}


class Point{
    public double x;
    public double y;
    public double z;
    String name;
    ArrayList<Point> points;

    public Point(String name, double x, double y, double z){
        this.name = name;
        this.x = x;
        this.y = y;
        this.z = z;
    }


    public void addPoint(Point point){
        this.points.add(point);
    }
}


class Line{
    Point p1;
    Point p2;


    public Line(Point p1, Point p2){
        this.p1 = p1;
        this.p2 = p2;
    }


    public double line_estimate(){
        return Math.sqrt(Math.pow((Math.abs(p1.x - p2.x)), 2) + Math.pow((Math.abs(p1.y - p2.y)), 2)+ Math.pow((Math.abs(p1.z - p2.z)), 2));
    }


    @Override
    public String toString(){
        String res = "";
        res = res + "Line " + this.p1.name + this.p2.name + ": ";
        if(this.line_estimate() > 0){
            return res + this.line_estimate();
        }else{
            return res + "same point";
        }
    }
}