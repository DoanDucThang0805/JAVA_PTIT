import java.util.ArrayList;


public class INHERITANCE003 {
    public static void main(String[] args) {
        String name = "Grocery Bill";
        Employee clerk1 = new Employee(name);
        GroceryBill groceryBill = new GroceryBill(clerk1);
        groceryBill.add(new Item("item 1", 2.3, 0));
        groceryBill.add(new Item("item 2", 3.45, 0));
        System.out.println(groceryBill.toString());
        System.out.println();
        name = "Discount Bill";
        Employee clerk2 = new Employee(name);
        DiscountBill discountBill = new DiscountBill(clerk2);
        discountBill.add(new Item("item 3", 20, 15));
        discountBill.add(new Item("item 4", 40, 35));
        discountBill.add(new Item("item 5", 50, 35));
        System.out.print(discountBill.toString());
    }
}


class Item{
    private String name;
    private double discount;
    private double price;


    public Item(String name, double price, double discount){
        this.name = name;
        this.price = price;
        this.discount = discount;
    }


    public String getName() {
        return name;
    }


    public double getDiscount() {
        return discount;
    }


    public double getPrice() {
        return price;
    }


    @Override
    public String toString(){
        return name + "$" + String.format("%.2f", price) + "(-$" + String.format("%.2f", discount) + ")";
    }
}


class Employee{
    private String name;

    public Employee(String name){
        this.name = name;
    }


    public String getName() {
        return name;
    }
}


class GroceryBill{
    private Employee clerk;
    private ArrayList<Item> receipt = new ArrayList<>();
    private static double total = 0.0;


    public GroceryBill(Employee clerk){
        this.clerk = clerk;
    }


    public void add(Item i){
        receipt.add(i);
        total = total + i.getPrice();
    }


    public static double getTotal() {
        return total;
    }


    public Employee getClerk() {
        return clerk;
    }

    public ArrayList<Item> getReceipt() {
        return receipt;
    }


    @Override
    public String toString(){
        StringBuilder result = new StringBuilder("items:\n");
        for (Item item : receipt){
            String name = item.getName();
            double price = item.getPrice();
            double dis_price = item.getDiscount();
            result.append("   ")
                    .append(name)
                    .append(" $")
                    .append(String.format("%.2f", price))
                    .append(" (-$")
                    .append(String.format("%.2f", dis_price))
                    .append(")\n");
        }
        result.append("total: $")
                .append(String.format("%.2f", getTotal()))
                .append("\nClerk: ")
                .append(this.getClerk().getName());
        return result.toString();
    }
}


class DiscountBill extends GroceryBill{
    private static double discountAmount = 0.0;
    private ArrayList<Item> receipt = new ArrayList<>();

    public DiscountBill(Employee clerk){
        super(clerk);
    }


    public double getDiscountAmount(){
        return discountAmount;
    }


    public ArrayList<Item> getReceipt() {
        return receipt;
    }


    @Override
    public void add(Item i){
        this.receipt.add(i);
        discountAmount = discountAmount + i.getPrice();
    }


    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("items:\n");
        double discount = 0.0;
        for(Item item : this.getReceipt()){
            String name = item.getName();
            double price = item.getPrice();
            double dis_price = item.getDiscount();
            discount = discount + dis_price;
            sb.append("   ")
                    .append(name)
                    .append(" $")
                    .append(String.format("%.2f", price))
                    .append(" (-$")
                    .append(String.format("%.2f", dis_price))
                    .append(")\n");
        }
        sb.append("sub-total: $")
                .append(String.format("%.2f", getDiscountAmount()))
                .append("\ndiscount: $")
                .append(String.format("%.2f", discount))
                .append("\ntotal: $")
                .append(String.format("%.2f", this.getDiscountAmount() - discount))
                .append("\nClerk: ")
                .append(this.getClerk().getName());
        return sb.toString();
    }
}
