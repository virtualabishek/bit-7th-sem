class BankSystem {
    private double amount;
    private double balance;
    private String accountName;
    public BankSystem(double balance, String accountName) {
        this.balance = balance;
        this.accountName = accountName;
    }
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be greater than 0.");
        } else {
            balance = balance + amount;
            System.out.println(amount + " deposited to your account.");
        }
    }
    public void withdraw(double amount) {
        if(amount < balance) {
        balance = balance - amount;
        System.out.println(amount + " withdrawn from your account.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }
    public void checkBalance() {
        System.out.println("Hi." + accountName +"! Your ballance on bank is: " + balance);
    }
}
public class Program {
    public static void main(String[] args) {
        BankSystem b1 = new BankSystem(50000.90, "Abi");
        b1.deposit(40000.20);
        b1.checkBalance();
        b1.withdraw(50000.20);
        b1.checkBalance();
    }
}
