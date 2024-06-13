import java.util.Collections;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static int rarest(TreeMap<String, Integer> map)
    {
        TreeMap<Integer, Integer> res = new TreeMap<>();
        for(String x : map.keySet())
        {
            int age = map.get(x);
            if(!res.containsKey(age))
            {
                res.put(age, 1);
            }
            else
            {
                int value = res.get(age);
                res.remove(age);
                res.put(age, value+1);
            }
        }
        // for(int x : res.keySet())
        // {
        //     System.out.println(x + " " + res.get(x));
        // }
        int min_xh = Collections.min(res.values());
        int ans = 0;
        // System.out.println(max_xh);
        for(int x : res.keySet())
        {
            if(res.get(x) == min_xh)
            {
                ans = x;
                break;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0)
        {
            String[] input = sc.nextLine().split(" ");
            TreeMap<String, Integer> store = new TreeMap<>();
            for(int i = 0; i < input.length; i += 2)
            {
                store.put(input[i], Integer.parseInt(input[i+1]));
            }
            // for(String x : store.keySet())
            // {
            //     System.out.println(x + " " + store.get(x));
            // }
            // System.out.println(rarest(store));
            System.out.println(rarest(store));
        }
    }
}