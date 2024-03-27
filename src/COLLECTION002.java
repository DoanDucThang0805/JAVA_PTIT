import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class COLLECTION002 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < testcase; i++){
            String line = sc.nextLine();
            String[] strings = line.split(" ");
            ArrayList<String> list = new ArrayList<>();
            Collections.addAll(list, strings);
            removeShorterString(list);

        }
    }

    public static String checkString(String a, String b) {
        if (a.length() < b.length()) {
            return b;
        } else if (a.length() == b.length()) {
            return b;
        } else {
            return a;
        }
    }

    public static void removeShorterString(ArrayList<String> list) {
        ArrayList<String> str = new ArrayList<>();
        for(int i = 0; i < list.size()-1; i+=2) {
            str.add(checkString(list.get(i), list.get(i + 1)));
        }
        if(list.size() % 2 != 0) str.add(list.get(list.size() - 1));
        StringBuilder res = new StringBuilder();
        for (String s : str) {
            res.append(" ").append(s);
        }
        System.out.println(res.substring(1));
    }
}
