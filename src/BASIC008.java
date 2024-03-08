public class BASIC008 {
    public static void main(String [] args){
        int sum = 0;
        System.out.println("Numbers between 100 and 200, divisible by 9:");
        for(int i = 99; i <= 200; i = i + 9){
            if(i == 99) continue;
            sum = sum + i;
            System.out.println(i);
        }
        System.out.println(sum);
    }
}
