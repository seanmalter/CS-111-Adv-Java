
public class Triangle extends Figure
{
	int sidelenght;
	Triangle(int sidelenght)
	{
		this.sidelenght = sidelenght;
	}
	
	@Override
	public void erase()
	{
		System.out.println("erase in class Triangle");
	}
	
	@Override
	public void draw()
	{
		System.out.println("draw in class Trianlge");		
	}
	
	@Override
	public void center()
	{
		draw();
		erase();
		System.out.println("center in class Triangle");
	}
}
