public class Drama extends Movie
{
	Drama(int id, String rating, String title)
	{
		super(id, rating, title);
	}
	
	//override default late fees
	private double LATE_FEE_RATE = 2;
	
	@Override
	public double calcLateFees(int days)
	{
		return days * LATE_FEE_RATE;
	}
}
