import java.util.HashSet;
import java.util.Scanner;

public class EXCEPTION003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        sc.nextLine();
        for(int t = 0; t < testcase; t++){
            String line = sc.nextLine();
            try {
                hasVowels(line);
            } catch (NoVowelsException e) {
                System.out.println("String not contain vowels");
            }
        }
        sc.close(); // Close the Scanner to prevent resource leak
    }

    public static void hasVowels(String str) throws NoVowelsException {
        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        boolean found = false;
        for(char ch : str.toCharArray()){
            if(vowels.contains(ch)){
                found = true;
                break;
            }
        }

        if(!found){
            throw new NoVowelsException("String does not contain vowels");
        }

        System.out.println("String has vowels");
    }

    // Custom Exception class for handling no vowels found
    static class NoVowelsException extends Exception {
        public NoVowelsException(String message) {
            super(message);
        }
    }
}
