import java.util.HashMap;
import java.util.Scanner;

public class COLLECTION003 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numCases; i++) {
            String line = scanner.nextLine();
            String[] entries = line.split(" ");
            HashMap<String, Integer> ageMap = new HashMap<>();
            for (int j = 0; j < entries.length; j += 2) {
                String name = entries[j];
                int age = Integer.parseInt(entries[j + 1]);
                ageMap.put(name, age);
            }
            System.out.println(rarest(ageMap));
        }
        scanner.close();
    }

    public static int rarest(HashMap<String, Integer> map) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        // Tính tần suất của từng độ tuổi
        for (int age : map.values()) {
            frequencyMap.put(age, frequencyMap.getOrDefault(age, 0) + 1);
        }

        int minAge = Integer.MAX_VALUE;
        int minFreq = Integer.MAX_VALUE;

        // Tìm độ tuổi có tần suất thấp nhất
        for (HashMap.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int age = entry.getKey();
            int freq = entry.getValue();

            if (freq < minFreq || (freq == minFreq && age < minAge)) {
                minFreq = freq;
                minAge = age;
            }
        }

        return minAge;
    }
}
