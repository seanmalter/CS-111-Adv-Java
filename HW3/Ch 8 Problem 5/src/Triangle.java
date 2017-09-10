
public class Triangle extends Figure
{
	int width, height;
	Triangle(int width, int height)
	{
		this width = width;
		this.height = height;
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
