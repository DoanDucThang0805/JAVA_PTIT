import java.util.Scanner;

public class ELAB2308 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        sc.nextLine();

        // Khởi tạo giá lăn bánh cao nhất là 0
        double maxSalePrice = 0;

        for(int i = 0; i < testcase; i++){
            String [] inputs = sc.nextLine().split(" ");
            double price = Double.parseDouble(inputs[1]);
            int year = Integer.parseInt(inputs[2]);
            String loaixe = inputs[0];
            Car car;
            if(loaixe.equals("SC")) {
                car = new SportCar(price, year);
            } else {
                car = new ClassicCar(price, year);
            }

            // Tính toán giá lăn bánh và in ra thông tin
            double salePrice = car.calculateSalePrice();
            System.out.println("Price: " + formatPrice(salePrice) + " VND | Year: " + year);

            // Cập nhật giá lăn bánh cao nhất nếu cần
            if (salePrice > maxSalePrice) {
                maxSalePrice = salePrice;
            }
        }

        // In ra giá lăn bánh cao nhất
        System.out.println("Most Expensive: " + formatPrice(maxSalePrice) + " VND");
    }

    // Phương thức này được sử dụng để định dạng giá lăn bánh để in ra
    private static String formatPrice(double price) {
        return String.format("%.2f", price).replaceAll("(\\d)(?=(\\d{3})+(?!\\d))", "$1,");
    }
}

class Car {
    public double price;
    public int year;

    public Car(double price, int year) {
        this.price = price;
        this.year = year;
    }

    public double calculateSalePrice() {
        return price;
    }
}

class ClassicCar extends Car {
    public ClassicCar(double price, int year) {
        super(price, year);
    }

    @Override
    public double calculateSalePrice() {
        double taxRate = 0.12;
        double registrationFee = 20000000; // 20 million VND
        return price * (1 + taxRate) + registrationFee;
    }
}

class SportCar extends Car {
    public SportCar(double price, int year) {
        super(price, year);
    }

    @Override
    public double calculateSalePrice() {
        double depreciation;
        if (year > 2018) {
            depreciation = 0.8; // 20% depreciation for cars produced after 2018
        } else if (year > 2010) {
            depreciation = 0.5; // 50% depreciation for cars produced after 2010
        } else {
            depreciation = 0.1; // 90% depreciation for cars produced before 2010
        }
        return price * depreciation;
    }
}
