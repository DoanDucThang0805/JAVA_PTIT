import java.util.Scanner;

public class Bieuthuc3diem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        sc.nextLine();
        for(int t = 0; t < testcase; t++){
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            sc.nextLine();
            Bieuthuc bieuthuc = new Bieuthuc(num1, num2);
            System.out.print(bieuthuc.add(num1, num2));
            System.out.print(" ");
            System.out.print(bieuthuc.subtract(num1, num2));
            System.out.print(" ");
            System.out.println(bieuthuc.divide(num1, num2));
        }
        sc.close();
    }
}

class Bieuthuc{
    int x;
    int y;


    public Bieuthuc(int x, int y){
        this.x = x;
        this.y = y;
    }


    public int add(int x, int y){
        return x+y;
    }


    public int subtract(int x, int y){
        return x-y;
    }


    public int divide(int x, int y){
        if(y == 0)  return 0;
        return x/y;
    }
}