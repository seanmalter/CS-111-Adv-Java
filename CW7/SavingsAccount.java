public class SavingsAccount extends BankAccount
{

  public static void main(String[] args) {
    SavingsAccount account1 = new SavingsAccount();
    SavingsAccount account2 = new SavingsAccount();

    System.out.println(account1);
    System.out.println(account2);
  }
  boolean active;

  pubilc void withdrawal(double amount)
  {
    if(active)
    {
      super.withdrawl(amount);
    }
    else
    {
      System.out.println("the balance is too low to withdrawal");
    }
  }

  public void deposit(double amount)
  {
    super.deposite(amount);
    if(super.getBalance() >= 25)
    {
      active = true;
    }
    else
    {
      active = false;
    }
  }

  public double monthlyProcess()
  {
    if(super.getWithdrawals() > 2)
    {
      if(super.getBalance - super.getWithdrawals - 2 < 25)
      {
        active = false;
      }
      return super.getWithdrawals - 2;
    }
    else
    {
      return 0;
    }
  }
}
