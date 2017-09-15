import java.util.Scanner;

public class Calculator
{

  public static void main(String[] args)
  {
    System.out.println("Calculator is on, result = 0");
    boolean going = true;
    Calculator c = new Calculator();

    while(going)
    {
      Scanner s = new Scanner(System.in);
      String input = s.nextLine();
      if(input.toLowerCase().equals("r"))
      {
        System.out.printf("final result = %f%n", c.getResult());
        c.resetResult();
        System.out.println("Do you wish to continue? (y/n)");
        String keepGoing = s.nextLine();
        if(keepGoing.toLowerCase().equals("y"))
        {
        	System.out.printf("the new result = 0.0%n");
        }
        else
        {
        	System.exit(0);
        }
      }
      else
      {
        c.calculate(input);
      }
    }
  }

  Calculator(){ }

  private double currentValue = 0.0;

  public double getResult()
  {
    return currentValue;
  }

  public void resetResult()
  {
  	currentValue = 0;
  }

  public boolean runAgain(String s)
  {
    switch(s.toLowerCase())
    {
      case "y":
        return true;
      default:
        return false;
    }
  }

  public void calculate(String s)
  {
  	
    String operator = s.substring(0,1);
    String numberString = s.substring(1).replaceAll("\\s+","");

    try
    {
      double number = Double.parseDouble(numberString);

      switch(operator)
      {
        case "+":
          add(number);
          break;
        case "-":
          subtract(number);
          break;
        case "*":
          multiply(number);
          break;
        case "/":
          divide(number);
          break;
        default:
          throw new UnknownOperatorException(operator);
      }
    }
    catch(UnknownOperatorException e)
    {
      System.out.println(e.getMessage());
      System.out.println("Reenter your last line:");
    }
    catch(Exception e)
    {
    	System.out.println("error converting number");
      System.out.println(e.getMessage());
    }
  }

  public void add(double d)
  {
    currentValue += d;
    System.out.printf("result + %f = %f%n", d, currentValue);
    System.out.printf("updated result = %f%n", currentValue);
  }

  public void subtract(double d)
  {
    currentValue -= d;
    System.out.printf("result - %f = %f%n", d, currentValue);
    System.out.printf("updated result = %f%n", currentValue);
  }

  public void multiply(double d)
  {
    currentValue *= d;
    System.out.printf("result * %f = %f%n", d, currentValue);
    System.out.printf("updated result = %f%n", currentValue);
  }

  public void divide(double d)
  {
    if(d == 0)
    {
      System.out.println("you cannot divide by 0");
    }
    else
    {
      currentValue /= d;
      System.out.printf("result / %f = %f%n", d, currentValue);
      System.out.printf("updated result = %f%n", currentValue);
    }
  }
}
