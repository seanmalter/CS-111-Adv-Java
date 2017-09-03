
public class MultiItemSale
{
	
	private Sale[] sales;
	private int count = 0;
	
	//DEFAULT CONSTRUCTOR
	public MultiItemSale()
	{
		sales = new Sale[6];
		count = 0;
	}
	
	// FULL CONSTRUCTOR
	public MultiItemSale(String[]
names, double[] prices, double[] discounts)	{
		sales = new Sale[names.length];
		for(int i = 0; i < names.length; i++){
			sales[i] = new DiscountSale(names[i], prices[i], discounts[i]);
			
			
			System.out.println(sales[i].getName());
			System.out.println(sales[i].getPrice());
			System.out.print(sales[i].getDiscount());
		}
	}
	
	//MODIFIERS
	public void addSale(Sale sale)
	{
		sales[count] = sale;
		count++;
	}

	public void  incrementCount()
	{
		count++;
	}
	
	
	public void decrementCount()
	{
		count--;
	}
	
	//EQUALS
	public boolean equals(Object anotherSale)
	{
		Sale other;
		other = (Sale) anotherSale;
		//return (this.name.equals(other.getName()))
		//	&& (this.price == other.getPrice());
		return false; 
	}
	
}