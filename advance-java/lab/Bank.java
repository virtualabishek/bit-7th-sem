/*
design a "BankAccount" class and implement methods deposit , withdraw and display_balance, apply interest. Create an instance of "BankAccount" with following details.
-> Account_holder_name
-> Account number
-> Balance
-> Acc_type
Deposit 500 and withdraw 200 and apply interest rate of 5% and display the updated balance.
*/

class BankAccount {
    private String account_holder_name;
    private String account_number;
    private double balance;
    private String account_type;

    // constructor
    public BankAccount (String account_holder_name, String account_number, double balance, String account_type) {
        this.account_holder_name = account_holder_name;
        this.account_number = account_number;
        this.balance = balance;
        this.account_type = account_type;
    }
    public void Deposit(double amount) {
        if(amount >= 0) {
            balance = balance + amount;
            // balance += amount
            System.out.println("Deposited: " + amount);
            System.out.println("Your total amount is: " + balance);
        } else {
            System.out.println("Your balance should should be greater than 0.");
        }
    }

    public void withdraw(double amount) {
        if(amount < balance) {
            System.out.println("Amount withdrawn: " + amount);
            System.out.println("Your current balance is: " + balance);
        } else {
            System.out.println("You dont have sufficient balance to withdraw.");
        }
    }

    public void displayBalance() {
        System.out.println("You have " + balance + "in your account");
        System.out.println("Your account number is" + account_number);
        System.out.println("Your account type is: " + account_type);
    }
    public void applyInterest() {
        double interest = balance * 13 /100;
        double totalBalance = balance + interest;
        System.out.println("Interest Applied: " + interest);
        System.out.println("Now your balance becomes: " + totalBalance);
    }

}


public class Bank {
    public static void main(String[] args) {
    BankAccount b1 = new BankAccount("Abi","22231243124", 2000.00, "Saving");
    b1.Deposit(2000);
    b1.displayBalance();
    b1.withdraw(1000);
    b1.displayBalance();
    b1.applyInterest();    
    b1.displayBalance();
    }

}