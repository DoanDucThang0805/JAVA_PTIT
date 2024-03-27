import java.util.HashMap;

public class COLLECTION001 {
    public static void main(String [] args) {
        Warehouse warehouse = new Warehouse();
        warehouse.addProduct("milk", 10);
        warehouse.addProduct("coffee", 7);
        System.out.println("prices:");
        System.out.println("milk: " + warehouse.stock("milk"));
        System.out.println("coffee: " + warehouse.stock("coffee"));
        System.out.println("sugar: " + warehouse.stock("sugar"));
    }
}

class Warehouse {
    HashMap<String , Integer> warehouse = new HashMap<>();

    public void addProduct(String product, int stock) {
        warehouse.put(product, stock);
    }

    public int stock(String product) {
        Integer stock = warehouse.get(product);
        if(stock == null) return -99;
        return stock;
    }
}