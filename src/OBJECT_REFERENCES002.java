import java.util.Scanner;

public class OBJECT_REFERENCES002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int day = 1;
        int month = 2;
        int year = 2000;
        SimpleDate d = new SimpleDate(day, month, year);
        System.out.println(d.equals("heh")); // false, different type
        System.out.println(d.equals(new SimpleDate(5, 2, 2012))); // true, same date
        System.out.println(d.equals(new SimpleDate(1, 2, 2000)));
        sc.close();
    }
}


class SimpleDate{
    int day;
    int month;
    int year;


    public SimpleDate(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }


    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null || !(obj instanceof SimpleDate)){
            return false;
        }
        SimpleDate other = (SimpleDate) obj;
        return this.day == other.day && this.month == other.month && this.year == other.year;
    }
}