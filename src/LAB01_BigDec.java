import java.math.BigDecimal;
import java.util.Scanner;


public class LAB01_BigDec {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < testCases; i++) {
            String line = sc.nextLine();
            String [] inputs = line.split("\\s+");
            BigDecimal [] arr = new BigDecimal[inputs.length];
            BigDecimal sum = BigDecimal.valueOf(0);
            for(int num = 0; num < inputs.length; num++){
                BigDecimal nums = new BigDecimal(inputs[num]);
                arr[num] = nums;
            }
            for (BigDecimal bigDecimal : arr) {
                sum = sum.add(bigDecimal.remainder(BigDecimal.ONE));
            }
            System.out.println(sum);
        }
        sc.close();
    }
}
