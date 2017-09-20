import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.util.List;
import java.util.ArrayList;

public class ReadWrite
{
  public static void main(String[] args)
  {
    ReadWrite RW = new ReadWrite();
    RW.readTxt();
    RW.writeTxt();
  }

  //placeholders to keep track of the numbers
  private List<Integer> numbers = new ArrayList<Integer>();
  private int previousNumberRead;
  private Scanner input = new Scanner(System.in);

  public void readTxt()
  {
    Scanner inputStream = null;
    System.out.println("enter the name of the file to be read");
    String fileName = input.next();
    try
    {
      inputStream = new Scanner(new FileInputStream(fileName));
    }
    catch(FileNotFoundException e)
    {
      System.out.println(e.getMessage());
      System.out.println("unable to open file");
      System.exit(0);
    }
    while(inputStream.hasNextInt())
    {
      int currentInt = inputStream.nextInt();
      if(currentInt != previousNumberRead)
      {
        numbers.add(currentInt);
      }
      previousNumberRead = currentInt;
    }
    inputStream.close();
  }

  public void writeTxt()
  {
    PrintWriter outputStream = null;
    System.out.println("enter the file name to write to");
    String fileName = input.next();
    try
    {
      outputStream = new PrintWriter(new FileOutputStream(fileName));
    }
    catch(FileNotFoundException e)
    {
      System.out.println(e.getMessage());
      System.out.println("unable to write file");
      System.exit(0);
    }
    for(int number : numbers)
    {
      outputStream.println(number);
    }
    outputStream.close();
  }
}
