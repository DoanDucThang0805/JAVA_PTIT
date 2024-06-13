public class OOP001 {
    public static void main(String[] args) {
        BankAccount savings = new BankAccount("Jimmy");
        savings.deposit(10.00);

        savings.deposit(50.00);

        savings.deposit(10.00);

        savings.deposit(70.00);

        System.out.println(savings.transactionFee(5.00));

        System.out.println(savings.transactionFee(10.00));
    }
}


class BankAccount{
    private final String id;
    private static double balance;
    private static int transaction;


    public BankAccount(String id){
        this.id = id;
        balance = 0.0;
        transaction = 0;
    }


    public double getBalance(){
        return balance;
    }


    public String getID(){
        return id;
    }


    public int getTransactions(){
        return transaction;
    }


    public void deposit(double amount){
        if(amount >= 0 && amount <= 500){
            balance += amount;
        }
        transaction += 1;
    }


    public void withdraw(double amount){
        if(balance >= amount){
            balance -= amount;
        }
        transaction += 1;
    }


    public boolean transactionFee(double amount){
        double cost = 0;
        for(int i = 1; i <= transaction; i++){
            cost += amount * i;
        }
        if(balance - cost > 0.00){
            balance -= cost;
            return true;
        }else{
            balance = 0.0;
        }
        return false;
    }
}
