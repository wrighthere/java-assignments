import java.util.Scanner;
import java.lang.System;
/*1. Bank Account: Create a class called BankAccount that simulates a bank account. The class should have methods to deposit, withdraw, and check the balance. You can also create a custom exception called InsufficientFundsException to throw when a withdrawal is attempted with insufficient funds.*/

class BankAccount {
  public static void main(String[] args) {
    BankDetails bd = new BankDetails();
    Scanner sc = new Scanner(System.in);
    while (true) {
      System.out.println("1. Deposit");
      System.out.println("2. Withdraw");
      System.out.println("3. Show Balance");
      System.out.println("4. Exit");
      int option = sc.nextInt();
      float value = 0;
      switch (option) {
        case 1:
          System.out.println("Enter amount to Deposit Deposit");
          value = sc.nextFloat();
          bd.Deposit(value);
          break;
        case 2:
          System.out.println("Enter amount to withdraw");
          value = sc.nextFloat();
          try {
            bd.Withdraw(value);
          } catch (InsufficientFundsException ex) {
            System.out.println(ex);
          }
          break;
        case 3:
          bd.ShowBalance();
          break;
        case 4:
          System.exit(0);
      }
    }
  }
}

class BankDetails {
  private float balance;

  public void Deposit(float amount) {
    balance += amount;
    System.out.println("New balance is " + balance);
  }

  public void Withdraw(float amount) throws InsufficientFundsException {
    if (amount > balance) {
      throw new InsufficientFundsException("Insufficient funds");
    }
    balance -= amount;
    System.out.println("New balance is " + balance);
  }

  public void ShowBalance() {
    System.out.println("balance is " + balance);
  }
}

class InsufficientFundsException extends Exception {
  public InsufficientFundsException(String errorMessage) {
    super(errorMessage);
  }
}