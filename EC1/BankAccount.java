import java.util.Scanner;
import java.util.InputMismatchException;

public class BankAccount
{
  private int accountNumber;
  private String name;
  private double balance;

  public BankAccount()
  {
    this.accountNumber = 0;
    this.name = "";
    this.balance = 0;
  }

  public BankAccount(int accountNumber, String name, double balance)
  {
  	if(name.length() >= 15)
  	{
  		System.out.println("your name is too long, please choose something smaller (less than 15 characters)");
  		name = "";
  	}
    this.accountNumber = accountNumber;
    this.name = name;
    this.balance = balance;
  }

  public int getAccountNumber()
  {
    return accountNumber;
  }

  public String getName()
  {
    return name;
  }

  public double getBalance()
  {
    return balance;
  }

  public void setAccountNumber(int accountNumber)
  {
    this.accountNumber = accountNumber;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public void setBalance(double balance)
  {
    this.balance = balance;
  }

  public String toString()
  {
    return "Name:" + name + "; Account Number: " + accountNumber + "; Balance: " + balance + ";";
  }

  public boolean equals(BankAccount account)
  {
    if(account.getAccountNumber() == accountNumber)
    {
      return true;
    }
    else
    {
      return false;
    }
  }

  public void newTransaction()
  {
    try
    {
      Scanner input = new Scanner(System.in);
      System.out.println();
      System.out.println("Enter Account number");
      int accountNumber = input.nextInt();
      input.nextLine();
      System.out.println("Enter Name on the account");
      String name = input.nextLine();
      System.out.println("Enter changes to the account balance +/-");
      double balanceChange = input.nextDouble();
      input.nextLine();

      if(name.length() > 15)
      {
        name = "";
      }

      this.accountNumber = accountNumber;
      this.name = name;
      this.balance += balanceChange;
    }
    catch(InputMismatchException e)
    {
      System.out.println("incorrect input");
    }
  }
}
