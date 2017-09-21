import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SearchNames
{
  public static void main(String[] args)
  {
    SearchNames s = new SearchNames();
    s.importData();
    System.out.println("enter a name to search");
    Scanner input = new Scanner(System.in);
    String search = input.next();
    s.searchBoys(search);
    s.searchGirls(search);
  }
  private String[] girlNames = new String[1000];
  private String[] boyNames = new String[1000];

  private int[] girlNameCount = new int[1000];
  private int[] boyNameCount = new int[1000];

  SearchNames() {};

  public void importData()
  {
    try
    {
      BufferedReader inputStream = new BufferedReader( new FileReader("boynames.txt"));
      System.out.println("Reading boys names");
      for(int i = 0; i < boyNames.length; i++){
        String line = inputStream.readLine();
        String[] splitLine = line.split(" ");
        boyNames[i] = splitLine[0];
        boyNameCount[i] = Integer.parseInt(splitLine[1]);
        //System.out.println("name is " + boyNames[i] + " and count is " + boyNameCount[i]);
      }
    }
    catch(FileNotFoundException e)
    {
      System.out.println("cannot open boysname.txt");
    }
    catch(IOException e)
    {
      System.out.println(e.getMessage());
    }

    try
    {
      BufferedReader inputStream = new BufferedReader( new FileReader("girlnames.txt"));
      System.out.println("Reading girl names");
      for(int i = 0; i < boyNames.length; i++){
        String line = inputStream.readLine();
        String[] splitLine = line.split(" ");
        girlNames[i] = splitLine[0];
        girlNameCount[i] = Integer.parseInt(splitLine[1]);
        //System.out.println("name is " + girlNames[i] + " and count is " + girlNameCount[i]);
      }
    }
    catch(FileNotFoundException e)
    {
      System.out.println("cannot open boysname.txt");
    }
    catch(IOException e)
    {
      System.out.println(e.getMessage());
    }
  }

  public void searchBoys(String name)
  {
    String lowercaseName = name.toLowerCase();
    for(int i = 0; i < boyNames.length; i++)
    {
      if(boyNames[i].toLowerCase().equals(lowercaseName))
      {
        System.out.printf("%s is ranked %d in popularity among boys with %d namings%n", name, i, boyNameCount[i]);
        return;
      }
    }
    System.out.printf("%s is not ranked among the top 1000 boy names%n", name);
  }

  public void searchGirls(String name)
  {
    String lowercaseName = name.toLowerCase();
    for(int i = 0; i < girlNames.length; i++)
    {
      if(girlNames[i].toLowerCase().equals(lowercaseName))
      {
        System.out.printf("%s is ranked %d in popularity among girls with %d namings%n", name, i, girlNameCount[i]);
        return;
      }
    }
    System.out.printf("%s is not ranked among the top 1000 girl names%n", name);
  }
}
