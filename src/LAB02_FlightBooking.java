import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class LAB02_FlightBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        sc.nextLine();
        for (int t = 0; t < testCases; t++) {
            FlightBooking.reset();
            String input = sc.nextLine();
            String[] actions = input.split(" ");
            StringBuilder output = new StringBuilder();
            for (int i = 0; i < actions.length; i += 2) {
                int userId = Integer.parseInt(actions[i]);
                String task = actions[i + 1];
                switch (task) {
                    case "Booking":
                        output.append(FlightBooking.book(userId));
                        break;
                    case "Confirmed":
                        output.append(FlightBooking.confirm(userId));
                        break;
                    case "Cancel":
                        output.append(FlightBooking.cancel(userId));
                        break;
                }
            }

            System.out.println(output);
        }
        sc.close();
    }
}


class FlightBooking {
    private static int seatAvailable = 180;
    private static final Map<Integer, String> bookings = new HashMap<>();


    public static String book(int userId) {
        if (seatAvailable > 0 && !bookings.containsKey(userId)) {
            bookings.put(userId, "Booked");
            seatAvailable--;
            return "[Seat Available: " + seatAvailable + "]";
        } else {
            return "No seats available or user has already booked";
        }
    }


    public static String confirm(int userId) {
        if (bookings.containsKey(userId) && bookings.get(userId).equals("Booked")) {
            bookings.put(userId, "Confirmed");
            return "--User " + userId + " Confirmed--[Seat Available: " + seatAvailable + "]";
        } else {
            return "User " + userId + " does not have a booking to confirm";
        }
    }


    public static String cancel(int userId) {
        if (bookings.containsKey(userId) && !bookings.get(userId).equals("Cancelled")) {
            bookings.put(userId, "Cancelled");
            seatAvailable++;
            return "[Seat Available: " + seatAvailable + "]";
        } else {
            return "User " + userId + " does not have a booking to cancel";
        }
    }


    public static void reset() {
        seatAvailable = 180;
        bookings.clear();
    }
}
