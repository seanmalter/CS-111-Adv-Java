
public class Triangle extends Figure
{
	int sideLength;
	String[][] drawing = super.getDrawing();
	
	Triangle(int sideLength)
	{
		this.sideLength = sideLength;
	}
	
	@Override
	public void erase()
	{
		 this.drawing = new String[10][10];
	}
	
	@Override
	public void draw(int offsetX, int offsetY)
	{
		drawing = super.resetDrawing();
		
		for(int i = 0; i < this.sideLength; i++)
		{
			for(int j = 0; j <= i; j++)
			{
				if(drawing[i + offsetY][j + offsetX] != null) {
					drawing[i + offsetY][j + offsetX] = "*";
				}
			}
		}
		this.setDrawing(drawing);
	}
	
	@Override
	public void center()
	{
		int offsetX = (10 - this.sideLength) / 2;
		int offsetY = (10 - this.sideLength) / 2;
		
		erase();
		draw(offsetX, offsetY);
	}
}
