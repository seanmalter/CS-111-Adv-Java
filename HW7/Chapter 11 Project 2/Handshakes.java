public class Handshakes
{
  public static void main(String[] args)
  {
  	System.out.println("the total handshakes for 4 people are:");
    System.out.println(totalHandshakes(4));
  	System.out.println("the total handshakes for 8 people are:");
    System.out.println(totalHandshakes(8));
    System.out.println("the total handshakes for 78 people are:");
    System.out.println(totalHandshakes(78));

  }

  public static int totalHandshakes(int n)
  {
    if(n == 1)
    {
      return 0;
    }
    else
    {
      return n-1 + totalHandshakes(n-1);
    }
  }
}
