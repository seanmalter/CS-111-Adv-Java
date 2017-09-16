public class SSNLengthException extends Exception
{
  SSNLengthException()
  {
    super("the length of the entered SSN is incorrect.\n Make sure you enter 9 numbers");
  }
}
