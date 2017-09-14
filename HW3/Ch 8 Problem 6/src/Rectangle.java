
public class Rectangle extends Figure
{
	private int width, height;
	private String[][] drawing = super.getDrawing();
	
	
	Rectangle()
	{
		this.width = 5;
		this.height = 5;
	}
	
	Rectangle(int width, int height)
	{
		this.width = width;
		this.height = height;
	}
	
	@Override
	public void erase()
	{
		 this.drawing = new String[10][10];
	}
	
	@Override
	public void draw(int offsetX, int offsetY)
	{
		for(int i = 0; i < drawing.length; i++)
		{
			for(int j = 0; j < drawing[0].length; j++)
			{
				if(i < height + offsetY && i >= offsetY && j >= offsetX && j < width + offsetX)
				{
					drawing[i][j] = "*";
				}
				else
				{
					drawing[i][j] = "-";
				}
			}
		}
		this.setDrawing(drawing);
	}
	
	@Override
	public void center()
	{
		int offsetX = (10 - this.width) / 2;
		int offsetY = (10 - this.height) / 2;
		erase();
		draw(offsetX, offsetY);
	}
}
