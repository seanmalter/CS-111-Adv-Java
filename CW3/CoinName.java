public class CoinName extends Exception
{
	CoinName()
	{
		super("The coin name entered doesn't match the value, try penny, nickel, " + 
		"dime, quarter");
	}
}