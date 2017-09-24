import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.EOFException;
import java.lang.Math;

public class StndDeviation
{
  public static void main(String[] args)
  {
    makeBinaryFile();
    StndDeviation stnd = new StndDeviation();
    stnd.getAverage("numbers.dat");
    stnd.calculateStnd();
  }
  private double average;
  private int numberCount;

  public void getAverage(String fileName)
  {
    try
    {
      ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName));
      try
      {
        while(true)
        {
          double number = inputStream.readDouble();
          average += number;
          numberCount++;
        }
      }
      catch(EOFException e)
      {
      	average = average / numberCount;
        System.out.printf("finished while loop and computed the average is %f%n", average);
      }
      inputStream.close();
    }
    catch(FileNotFoundException e)
    {
      System.out.println(e.getMessage());
    }
    catch(IOException e)
    {
      System.out.println(e.getMessage());
    }
  }

  public void calculateStnd()
  {
    int count = 0;
    double calcStnd;
    double sum = 0;
    try
    {
      ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("numbers.dat"));
      try
      {
        while(true)
        {
          double number = inputStream.readDouble();
          sum += Math.pow(number - average,2);
          count++;
        }
      }
      catch(EOFException e)
      {
      	calcStnd = Math.sqrt(sum/count);
        System.out.printf("finished while loop and computed the standard deviation is %f%n", calcStnd);
      }
      inputStream.close();
    }
    catch(FileNotFoundException e)
    {
      System.out.println(e.getMessage());
    }
    catch(IOException e)
    {
      System.out.println(e.getMessage());
    }
  }

  public static void makeBinaryFile()
  {
    try
    {
      ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("numbers.dat"));
      double[] numbers = {1.22, 7.65, 3.24, 21.88, 13.2, 156.7};

      for(double number : numbers)
      {
      	System.out.println(number);
        outputStream.writeDouble(number);
      }
      outputStream.close();
    }
    catch(IOException e)
    {
      System.out.println(e.getMessage());
    }
  }
}
