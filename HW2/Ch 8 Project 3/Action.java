public class Action extends Movie
{
	Action(int id, String rating, String title)
	{
		super(id, rating, title);
	}
	
	//override default late fees
	private double LATE_FEE_RATE = 3;
	
	@Override
	public double calcLateFees(int days)
	{
		return days * LATE_FEE_RATE;
	}
}
