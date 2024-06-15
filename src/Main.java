import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class Main {
    public static void main(String[] args) {

    }
}

class Items{
    private String name;
    private double price;
    private double discount;

    public Items(String name, double price, double discount){
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        String res = "   ";
        return res + this.getName() + " " + String.format("$.%2f", this.getPrice()) + " " + String.format("$%.2f", this.getDiscount());
    }
}

class Employees{
    private String name;

    public Employees(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class GroceryBills{
    private Employees clerk;
    private ArrayList<Items> receipt = new ArrayList<>();
    private static double total = 0.0;

    public GroceryBills(Employees clerk){
        this.clerk = clerk;
    }

    public static double getTotal() {
        return total;
    }

    public ArrayList<Items> getReceipt() {
        return receipt;
    }

    public Employees getClerk() {
        return clerk;
    }

    public void add(Items item){
        this.getReceipt().add(item);
        total = total + item.getPrice();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("items:\n");
        for (Items items : receipt){
            sb.append(items.toString());
        }
        String totals = String.format("total: $%.2f\n", getTotal());
        sb.append(totals);
        sb.append("Clerk: ").append(this.clerk.getName());
        return sb.toString();
    }
}

class DisscountBills extends {

}