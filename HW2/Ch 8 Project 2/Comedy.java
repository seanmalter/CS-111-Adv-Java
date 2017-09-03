public class Comedy extends Movie
{
	Comedy(int id, String rating, String title)
	{
		super(id, rating, title);
	}
	
	//override default late fees
	private double LATE_FEE_RATE = 2.5;
	
	@Override
	public double calcLateFees(int days)
	{
		return days * LATE_FEE_RATE;
	}
}
