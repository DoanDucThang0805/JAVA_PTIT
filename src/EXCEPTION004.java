import java.util.Scanner;

class NameNotValidException extends Exception {
    public NameNotValidException(String message) {
        super(message);
    }
}

class AgeNotValidException extends Exception {
    public AgeNotValidException(String message) {
        super(message);
    }
}

class Persons {
    private final String name;
    private final int age;

    public Persons(String name, int age) throws NameNotValidException, AgeNotValidException {
        if (name == null || name.isEmpty() || name.length() > 40) {
            throw new NameNotValidException("Name is not valid");
        }
        this.name = name;

        if (age < 0 || age > 120) {
            throw new AgeNotValidException("Age is not valid");
        }
        this.age = age;
    }

    @Override
    public String toString() {
        return "Name: " + name + "--Age:" + age;
    }
}

public class EXCEPTION004 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfTestCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after nextInt()

        StringBuilder outputBuilder = new StringBuilder();

        for (int i = 0; i < numOfTestCases; i++) {
            try {
                String name = scanner.nextLine().trim();
                int age = Integer.parseInt(scanner.nextLine().trim());

                Persons persons = new Persons(name, age);
                outputBuilder.append(persons).append("\n");
            } catch (NameNotValidException | AgeNotValidException e) {
                outputBuilder.append(e.getMessage()).append("\n");
            }
        }

        scanner.close(); // Close the scanner

        // Print all output at once
        System.out.print(outputBuilder.toString().trim());
    }
}
