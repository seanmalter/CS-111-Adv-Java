

public class MultiItemSaleDriver
{
	
	public static void main(String[] args)
	{
		String[] names = {"popcorn","bread", "eggs"};
		double[] prices = {1.0, 5.0, 3.0};
		double[] discounts = {0.0, 0.0, 1.0};
		
		//MultiItemSale multiSale1 = new MultiItemSale(4);
		//MultiItemSale multiSale2 = new MultiItemSale(3);
		MultiItemSale multiSale3 = new MultiItemSale(names, prices, discounts);
		
		 //System.out.println(multiSale1.equals(multiSale2));
	}
}