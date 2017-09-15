public class CoinName extends Exception
{
	CoinName()
	{
		super("The coin name entered is not a valid coin, try penny, nickel, " + 
		"dime, quarter");
	}
}