public class Factorial
{
  public static void main(String[] args)
  {
    System.out.println("The factorial of 10 is:");
    System.out.println(factorial(10));

    System.out.println("The factorial of 43 is:");
    System.out.println(factorial(43));
  }

  public static int factorial(int n)
  {
    if(n <= 0)
    {
      return 1;
    }
    else
    {
      return n * factorial(n-1);
    }
  }
}
