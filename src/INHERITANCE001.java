public class INHERITANCE001 {
    public static void main(String[] args) {
        String name = "Ollie";
        String address = "6381 Hollywood Blvd. Los Angeles 90028";
        Students student = new Students(name, address);
        System.out.println(student);
        System.out.println("Study credits " + student.getCredit());
        int tmp = student.study();
        System.out.println("Study credits " + tmp);
    }
}


class Person{
    private final String name;
    private final String address;


    public Person(String name, String address){
        this.name = name;
        this.address = address;
    }


    @Override
    public String toString(){
        return name + " - " + address;
    }
}


class Students extends Person{
    private static int credit = 0;


    public Students(String name, String address){
        super(name, address);
    }


    public int getCredit() {
        return credit;
    }


    public int study(){
        credit = credit + 1;
        return credit;
    }
}