public class UnknownOperatorException extends Exception
{
  UnknownOperatorException(String s)
  {
    super(s + " is an unknown operation.");
  }
}
