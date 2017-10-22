public class Factorial
{
  public static void main(String[] args)
  {
    System.out.print("The factorial of 10 is: ");
    System.out.print(factorial(10));
	System.out.println();
    System.out.print("The factorial of 43 is: ");
    System.out.print(factorial(30));
    System.out.println();
  }

  public static int factorial(int n)
  {
    if(n < 0)
    {
      return -1;
    }
    if(n == 0)
    {
      return 1;
    }
    else
    {
      return n * factorial(n-1);
    }
  }
}
