import java.util.Scanner;


public class ELAB2310 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Test.open_file(s);
        sc.close();
    }
}


class  FileNameFormatExeption extends Exception{
    public FileNameFormatExeption(String message){
        super(message);
    }
}


class Test{
    public static void open_file(String s){
        try{
            f(s);
            System.out.println("File opened");
        }catch (FileNameFormatExeption fname){
            System.out.println(fname.getMessage());
        } catch (Exception e) {
            System.out.println("Exception");
        }
    }


    public static void  f(String s) throws  FileNameFormatExeption{
        for(char x : s.toCharArray()){
            if(x == ' '){
                throw new FileNameFormatExeption("File name format");
            }
        }
    }
}