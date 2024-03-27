import java.util.ArrayList;
import java.util.Scanner;

public class BASIC012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < testcase; i++){
            ArrayList<Integer> array = new ArrayList<>();
            String text = sc.nextLine();
            String [] input = text.split("\\s+");
            for (String s : input) {
                int nums = Integer.parseInt(s);
                array.add(nums);
            }
            int result = longestSortedSequence(array);
            System.out.println(result);
        }
        sc.close();
    }

    public static int longestSortedSequence(ArrayList<Integer> array){
        if(array.isEmpty()){
            return 0;
        }
        int max_length = 1;
        int current_length = 1;
        for(int i = 1; i < array.size(); i++){
            if(array.get(i) >= array.get(i - 1)){
                current_length = current_length + 1;
            }else{
                if(current_length > max_length){
                    max_length = current_length;
                }
                current_length = 1;
            }
        }
         if(current_length > max_length){
             max_length = current_length;
         }
        return max_length;
    }
}
