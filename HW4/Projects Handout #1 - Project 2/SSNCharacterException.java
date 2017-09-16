public class SSNCharacterException extends Exception
{
  SSNCharacterException()
  {
    super("There is a character that is not a digit in your SSN.\n Please only enter numbers for your SSN");
  }
}
