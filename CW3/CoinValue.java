public class CoinValue extends Exception
{
	CoinValue()
	{
		super("That value is not a value of a coin, try 1, 5, 10, 25");
	}
}