import java.util.Scanner;

public class BASIC004 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0){
            String name_input = sc.nextLine();
            System.out.println("Hi " + name_input);
        }
    }
}
