import java.util.Arrays;

public class MaxValue
{
	public static void main(String[] args)
	{
		double[] d = {1,2,3,4,5,20};
		System.out.println(getMax(d)[0]);
	}
	
	public static double[] getMax(double[] x)
	{
		if(x.length == 1)
		{
			return x;
		}
		else if(x[0] > x[1])
		{
			x[1] = x[0];
			return getMax(Arrays.copyOfRange(x,1, x.length));
		}
		else
		{
			return getMax(Arrays.copyOfRange(x, 1, x.length));
		}
	}
}