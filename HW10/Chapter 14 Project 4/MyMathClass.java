import java.util.ArrayList;
import java.util.Scanner;

public class MyMathClass<T extends Number>
{

  public static void main(String[] args)
  {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Integer> doubles = new ArrayList<Integer>();
    int i = 0;
    while(i < 10)
    {
      System.out.println("enter another number");
      int temp = scanner.nextInt();
      scanner.nextLine();
      doubles.add(temp);
      i++;
    }
    MyMathClass<Integer> test = new MyMathClass<Integer>();
    test.AddToList(doubles);
    System.out.println("the standard deviation is " + test.CalculateStndDev());
  }

  private ArrayList<T> data;

  public MyMathClass()
  {
    data = new ArrayList<T>();
  }

  public void AddToList(ArrayList<T> numbers)
  {
    for( T number : numbers )
    {
      data.add(number);
    }
  }

  public double CalculateAverage()
  {
    double sum = 0;
    for( T number: data)
    {
      sum += number.doubleValue();
    }
    return sum / data.size();
  }

  public double CalculateStndDev()
  {
    double average = CalculateAverage();
    double sum = 0;
    for( T number : data)
    {
      sum += Math.pow( number.doubleValue() - average, 2);
    }
    return Math.sqrt(sum / (data.size() - 1));
  }
}
