
public class Rectangle extends Figure
{
	int width, height;
	
	Rectangle(int width, int height)
	{
		this.width = width;
		this.height = height;
	}
	
	@Override
	public void erase()
	{
		System.out.println("erase in class Rectangle");
	}
	
	@Override
	public void draw()
	{
		System.out.println("draw in class Rectangle");		
	}
	
	@Override
	public void center()
	{
		draw();
		erase();
		System.out.println("center in class Rectangle");
	}
}
