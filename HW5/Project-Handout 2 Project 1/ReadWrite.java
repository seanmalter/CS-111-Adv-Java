import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ReadWrite
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    ReadWrite RW = new ReadWrite();
    System.out.println("enter the name of the text file to read");
    String name = input.next();
    RW.readTxtFile(name);
  }

  public void readTxtFile(String fileName)
  {
    Scanner inputStream = null;
    try
    {
      inputStream = new Scanner(new FileInputStream(fileName));
    }
    catch(FileNotFoundException e)
    {
      System.out.println(e.getMessage());
    }
  }
}
