import java.util.ArrayList;

public class INHERITANCE003 {
    public static void main(String[] args) {
        Employee clerk1 = new Employee("Grocery Bill");
        GroceryBill groceryBill = new GroceryBill(clerk1);
        groceryBill.add(new Item("item 1", 2.3, 0));
        groceryBill.add(new Item("item 2", 3.45, 0));
        System.out.println(groceryBill);
        System.out.println();
        Employee clerk2 = new Employee("Discount Bill");
        DiscountBill discountBill = new DiscountBill(clerk2);
        discountBill.add(new Item("item 3", 20, 15));
        discountBill.add(new Item("item 4", 40, 35));
        discountBill.add(new Item("item 5", 50, 35));
        System.out.println(discountBill);
    }
}

class Item {
    private final String name;
    private final double price;
    private final double discount;

    public Item(String name, double price, double discount) {
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public double getDiscount() {
        return this.discount;
    }

    public String toString() {
        return String.format("%s $%.2f (-$%.2f)", this.name, this.price, this.discount);
    }
}

class Employee {
    private final String clerk;

    public Employee(String clerk) {
        this.clerk = clerk;
    }

    public String getName() {
        return this.clerk;
    }
}

class GroceryBill {
    private final Employee clerk;
    private final ArrayList<Item> receipt = new ArrayList<>();

    public GroceryBill(Employee clerk) {
        this.clerk = clerk;
    }

    public Employee getClerk() {
        return this.clerk;
    }

    public ArrayList<Item> getReceipt() {
        return this.receipt;
    }

    public void add(Item i) {
        this.receipt.add(i);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("items:\n");
        double total = 0.0;
        for (Item i : receipt) {
            sb.append("   ").append(i.toString()).append("\n");
            total += i.getPrice();
        }
        sb.append(String.format("total: $%.2f\n", total));
        sb.append("Clerk: ").append(this.clerk.getName());
        return sb.toString();
    }
}

class DiscountBill extends GroceryBill {
    private double discountAmount = 0.0;
    private double totalAmount = 0.0;

    public DiscountBill(Employee clerk) {
        super(clerk);
    }

    @Override
    public void add(Item i) {
        super.add(i);
        totalAmount += i.getPrice();
        discountAmount += i.getDiscount();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("items:\n");
        for (Item i : this.getReceipt()) {
            sb.append("   ").append(i.toString()).append("\n");
        }
        sb.append(String.format("sub-total: $%.2f\n", totalAmount));
        sb.append(String.format("discount: $%.2f\n", discountAmount));
        sb.append(String.format("total: $%.2f\n", totalAmount - discountAmount));
        sb.append("Clerk: ").append(this.getClerk().getName());
        return sb.toString();
    }
}