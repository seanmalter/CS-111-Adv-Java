import java.util.Scanner;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.EOFException;
import java.io.Serializable;
import java.io.FileNotFoundException;

public class Loan implements Serializable
{
  public static void main(String[] args) throws ClassNotFoundException
  {
    Scanner keyboard = new Scanner(System.in);

		//VALUES NEEDED
		double interestRate;
		int numberOfYears;
		double loanAmount;

    Loan[] loans = new Loan[5];
    //create the first 3 Loans in the array
    for(int i=0; i < 5; i++)
    {
      //PROMPT FOR LOAN 1 VALUES
      System.out.printf("GATHERING DETAILS FOR LOAN %d:%n", i);
      System.out.print("Enter specified interest rate for this loan: ");
      interestRate = keyboard.nextDouble();
      System.out.print("Enter # of years for this loan: ");
      numberOfYears = keyboard.nextInt();
      System.out.print("Enter loan amount for this loan: ");
      loanAmount = keyboard.nextDouble();

      loans[i] = new Loan(interestRate,numberOfYears,loanAmount);
    }

    ObjectOutputStream outputStream = null;
    try
    {
      outputStream = new ObjectOutputStream( new FileOutputStream("loans.dat"));
      outputStream.writeObject(loans[0]);
      outputStream.writeObject(loans[1]);
      outputStream.writeObject(loans[2]);
      outputStream.close();
    }
    catch(IOException e)
    {
      System.out.println(e.getMessage());
    }

    try
    {
      AppendObjectOutputStream appendOutputFile = new AppendObjectOutputStream( new FileOutputStream("loans.dat", true));
      appendOutputFile.writeObject(loans[3]);
      appendOutputFile.writeObject(loans[4]);
      appendOutputFile.close();
    }
    catch(IOException e)
    {
      System.out.println(e.getMessage());
    }

    ObjectInputStream inputStream = null;
    try
    {
      inputStream = new ObjectInputStream( new FileInputStream("loans.dat"));
      while(true)
      {
        Loan newLoan = (Loan) inputStream.readObject();
        System.out.println(newLoan);
      }
    }
    catch(EOFException e)
    {
      System.out.println("reached the end of the file");
    }
    catch(FileNotFoundException e)
    {
      System.out.println(e.getMessage());
    }
    catch(IOException e)
    {
      System.out.println(e.getMessage());
    }
  }
  private String customerName, loanDate;
  private double annualInterestRate, loanAmount, monthlyPayment, totalPayment;
  private int numberOfYears;

  public Loan()
  	{
  		this.setCustomerName("John Doe"); // DEFAULT
  		this.loanDate = "January 1, 2000"; // DEFAULT

  		//this.getDataFromUser(); // GETTING OUR THREE
  								//	USER-GIVEN PIECES OF DATA

  		this.calcMonthlyPayment(); // GETTING AND SETTING MONTHLY PAYMENT
  		this.calcTotalPayment();	// GETTING AND SETTING TOTAL PAYMENT
  	}
  	public Loan (double annualInterestRate,int numberOfYears, double loanAmount)
  	{
  		this.setCustomerName("John Doe");
  		this.loanDate = "January 1, 2000";

  		this.setAnnualInterestRate(annualInterestRate);
  		this.setNumberOfYears(numberOfYears);
  		this.setLoanAmount(loanAmount);

  		this.calcMonthlyPayment();
  		this.calcTotalPayment();
  	}
  	////////////////////////////////////////////////////////////////////////////





  	////////////////////////////////////////////////////////////////////////////
  	//SETTERS BELOW
  	////////////////////////////////////////////////////////////////////////////
  	////////////////////////////////////////////////////////////////////////////
  	public void setCustomerName(String customerName)
  	{
  		this.customerName = customerName;
  	}
  	public void setAnnualInterestRate(double annualInterestRate)
  	{
  		this.annualInterestRate = annualInterestRate;
  	}
  	public void setNumberOfYears(int numberOfYears)
  	{
  		this.numberOfYears = numberOfYears;
  	}
  	public void setLoanAmount(double loanAmount)
  	{
  		this.loanAmount = loanAmount;
  	}
  	////////////////////////////////////////////////////////////////////////////




  	////////////////////////////////////////////////////////////////////////////
  	//GETTERS BELOW
  	////////////////////////////////////////////////////////////////////////////
  	////////////////////////////////////////////////////////////////////////////
  	public String getCustomerName()
  	{
  		return this.customerName;
  	}
  	public double getAnnualInterestRate()
  	{
  		return this.annualInterestRate;
  	}
  	public int getNumberOfYears()
  	{
  		return this.numberOfYears;
  	}
  	public double getLoanAmount()
  	{
  		return this.loanAmount;
  	}
  	public String getLoanDate()
  	{
  		return this.loanDate;
  	}
  	public double getMonthlyPayment()
  	{
  		return this.monthlyPayment;
  	}
  	public double getTotalPayment()
  	{
  		return this.totalPayment;
  	}
  	////////////////////////////////////////////////////////////////////////////


  	////////////////////////////////////////////////////////////////////////////
  	//SPECIAL METHODS
  	////////////////////////////////////////////////////////////////////////////
  	////////////////////////////////////////////////////////////////////////////
  	public String toString()
  	{
  		return String.format("----------\nLoan for %s" +
  		"\nAMOUNT: $%.2f at %.2f%% interest annually." +
  		"\nYEARS: %d \nDATE CREATED: %s\nMONTHLY PAYMENT: $%.2f \nTOTAL PAYMENT: $%.2f",
  				customerName, loanAmount, annualInterestRate,
  				numberOfYears,loanDate,monthlyPayment,totalPayment);

  	}
  	////////////////////////////////////////////////////////////////////////////

  public void calcMonthlyPayment()
  {
    double monthlyInterestRate = annualInterestRate / 1200;
	  monthlyPayment = loanAmount * monthlyInterestRate /( 1 - (Math.pow(1 / (1 + monthlyInterestRate), numberOfYears * 12)));
  }

  public void calcTotalPayment()
  {
	  this.totalPayment = this.monthlyPayment * this.numberOfYears * 12;
  }
}
