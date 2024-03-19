import java.util.Scanner;
import java.util.ArrayList;

public class ELAB2302 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        // Đọc dữ liệu từ bàn phím cho đến khi không còn dòng nào
        while(sc.hasNextLine()) {
            String name = sc.nextLine();
            if (name.isEmpty()) // Kiểm tra nếu tên là dòng trống, thoát khỏi vòng lặp
                break;
            int age = Integer.parseInt(sc.nextLine()); // Đọc tuổi từ dòng tiếp theo
            students.add(new Student(name, age));
        }

        // Hiển thị danh sách sinh viên có tuổi lớn hơn hoặc bằng 18
        for(Student student : students) {
            student.display();
        }

        // Hiển thị tổng số sinh viên
        Student.getStudent();
    }
}

class Student {
    private final String name;
    private final int age;
    static int totalStudent = 0;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        totalStudent += 1; // Tăng biến đếm số sinh viên
    }

    public void display() {
        if(age >= 18) {
            System.out.println(name);
        }
    }

    public static void getStudent() {
        System.out.println(totalStudent);
    }
}
