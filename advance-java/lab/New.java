/*
design a "BankAccount" class and implement methods deposit , withdraw and display_balance, apply interest. Create an instance of "BankAccount" with following details.
-> Account_holder_name
-> Account number
-> Balance
-> Acc_type
Deposit 500 and withdraw 200 and apply interest rate of 5% and display the updated balance.
*/

class BankAccount {
  private String accountHolderName;
  private String accountNumber;
  private double balance;
  private String accountType;

  public BankAccount(String accountHolderName, String accountNumber, double balance, String accountType) {
    this.accountHolderName = accountHolderName;
    this.accountNumber = accountNumber;
    this.balance = balance;
    this.accountType = accountType;
  }

  public void deposit(double amount) {
    if (amount > 0) {
      balance += amount;
      System.out.println("Deposited: " + amount);
    } else {
      System.out.println("Invalid deposit amount.");
    }
  }

  public void withdraw(double amount) {
    if (amount <= 0) {
      System.out.println("Invalid withdrawal amount.");
      return;
    }
    if (amount > balance) {
      System.out.println("Insufficient balance.");
      return;
    }
    balance -= amount;
    System.out.println("Withdrawn: " + amount);
  }

  public void applyInterest(double ratePercent) {
    if (ratePercent <= 0) {
      System.out.println("Invalid interest rate.");
      return;
    }
    double interest = balance * ratePercent / 100.0;
    balance += interest;
    System.out.println("Interest applied: " + interest);
  }

  public void displayBalance() {
    System.out.println("Account Holder: " + accountHolderName);
    System.out.println("Account Number: " + accountNumber);
    System.out.println("Account Type: " + accountType);
    System.out.println("Balance: " + balance);
  }
}

public class New {
  public static void main(String[] args) {
    BankAccount account = new BankAccount("Account_holder_name", "123456", 1000.0, "Savings");
    account.deposit(500.0);
    account.withdraw(200.0);
    account.applyInterest(5.0);
    account.displayBalance();
  }
}