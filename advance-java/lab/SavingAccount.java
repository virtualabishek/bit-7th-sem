/* Create bank BankAccount with 
-> private fields: accountNumber, accountHolderName, balance
-> methods: deposit (double account) & withdraw (double amount)
Create a subclass SavingsAccount that
  -> has an additional field interest rate 
  -> overides a method to add interest to balance annually

Prevent withdraw if balance is insuffiecient
*/

public class BankAccount {
  private String accountNumber;
  private String accountHolderName;
  private double balance;

  // Constructor for initializing the values
  public BankAccount(String accountNumber, String accountHolderName, double balance) {
    this.accountNumber = accountNumber;
    this.accountHolderName = accountHolderName;
    this.balance = balance;
  }

  // deposit methods
  public void deposit(double amount) {
    if (amount > 0) {
      balance = balance + amount;
      System.out.println("Amount deposited: " + amount);
      System.out.println("Now you have: " + balance);
    } else {
      System.out.println("Invalid deposit amount!");
    }
  }

  // withdraw methods
  public void withdraw(double amount) {
    if (amount > 0 && amount <= balance) {
      balance = balance - amount;
      System.out.println("You withdrawn: " + amount);
      System.out.println("Now you have: " + balance);
    } else if (amount > balance) {
      System.out.println("Your balance is lesser than the amount. So you can't withdraw it.");
    } else {
      System.out.println("Invalid withdrawal amount!");
    }
  }

  // methods to get a balance
  public double getBalance() {
    return balance;
  }

  // to display info
  public void displayAccountInfo() {
    System.out.println("Account Number: " + accountNumber);
    System.out.println("Account Holder: " + accountHolderName);
    System.out.println("Balance: " + balance);
  }
}

class SavingsAccount extends BankAccount {
  private double interestRate;

  // Constructor
  public SavingsAccount(String accountNumber, String accountHolderName, double initialBalance, double interestRate) {
    super(accountNumber, accountHolderName, initialBalance);
    this.interestRate = interestRate;
  }

  public void addAnnualInterest() {
    double interest = getBalance() * interestRate / 100;
    deposit(interest);
    System.out.println("Annual interest added: " + interest);
  }

  @Override
  public void displayAccountInfo() {
    super.displayAccountInfo();
    System.out.println("Interest Rate is: " + interestRate + "%");
  }
}

class BankRun {
  public static void main(String[] args) {
    BankAccount account = new BankAccount("123456", "John Doe", 1000.0);
    account.displayAccountInfo();
    account.deposit(500.0);
    account.withdraw(300.0);
    account.withdraw(1500.0);
    SavingsAccount savingsAccount = new SavingsAccount("789012", "Jane Smith", 2000.0, 5.5);
    savingsAccount.displayAccountInfo();
    savingsAccount.deposit(1000.0);
    savingsAccount.addAnnualInterest();
    savingsAccount.withdraw(500.0);
  }
}