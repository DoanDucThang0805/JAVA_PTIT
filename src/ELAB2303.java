import java.util.Objects;

class MyStuff {
    private final String name;

    MyStuff(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }
        MyStuff myStuff = (MyStuff) obj;
        return Objects.equals(name, myStuff.name);
    }
}
public class ELAB2303 {
    public static void main(String[] args) {
        MyStuff m1 = new MyStuff("PC");
        MyStuff m2 = new MyStuff("PC");

        if (m2.equals(m1)){
            System.out.print("value compared: ");
            System.out.println("same");
        }else{
            System.out.println("different");
            System.out.print("value compared: ");
        }

        System.out.print("reference compared: ");
        if(m2 == m1){
            System.out.println("same");
        }else{
            System.out.println("different");
        }

    }
}