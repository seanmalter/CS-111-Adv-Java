import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

class PredatorPrey
{
  public static void main(String[] args)
  {
  	Scanner input = new Scanner(System.in);
  	System.out.println("Type 'load' to load the last map");
  	Simulation map1;
    //see if the user typed load into the console, if not make a new bugmap
  	String loadMap = input.nextLine();
  	if(!loadMap.toLowerCase().equals("load"))
  	{
  		map1 = new Simulation();
  	}
  	else
  	{
      //try to load the bugmap from bugMap.dat
  		try
  		{
  			FileInputStream inputStream = new FileInputStream("bugMap.dat");
      ObjectInputStream ObjInput = new ObjectInputStream(inputStream);
      map1 = (Simulation) ObjInput.readObject();
      ObjInput.close();
  		}
  		catch(Exception e)
  		{
  			System.out.println("couldn't get file, making new map " + e.getMessage());
  			map1 = new Simulation();
  		}
  	}

    //continue looping through the simulation until the user types exit
    while(true)
    {

      map1.timeStep();
      map1.printMap();
      System.out.println("press enter to continue, type exit to end and save");
      if(input.nextLine().toLowerCase().equals("exit"))
      {
      	break;
      }
    }

    //saves the map as bugMap.dat
    try
    {
      FileOutputStream outputStream = new FileOutputStream("bugMap.dat");
      ObjectOutputStream output = new ObjectOutputStream(outputStream);
      output.writeObject(map1);
      output.close();
    }
    catch(FileNotFoundException e) { }
    catch(IOException e) { }
  }
}
