import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


public class BugMap
{
  Organism[][] map;
  BugMap()
  {
    System.out.println("created a new map");
    map = new Organism[20][20];
    map[1][1] = new Doodlebug(1,1);
    map [2][2] = new Ant(2,2);
    breed(map[2][2]);
  }

  //accessors
  public Organism getSpace(int row, int column)
  {
    return map[row][column];
  }

  public Organism[][] getMap()
  {
    return map;
  }
  //get neighbors, key maps to what spaces are available
  public HashMap<String, Organism> getNeighbors(int row, int column)
  {
    HashMap<String, Organism> neighbors = new HashMap<String, Organism>();

    //check if top is inside the map
    if(row - 1 >= 0)
    {
      neighbors.put("up", map[row - 1][column]);
    }
    //check left
    if(column - 1 >= 0)
    {
      neighbors.put("left", map[row][column - 1]);
    }
    //check right
    if(column + 1 < 20)
    {
      neighbors.put("right", map[row][column + 1]);
    }
    //check bottom
    if(row + 1 < 20)
    {
      neighbors.put("down", map[row + 1][column]);
    }
    return neighbors;
  }

  //mutator
  public void setSpace(int row, int column, Organism bug)
  {
    map[row][column] = bug;
  }

  public void removeBug(int row, int column)
  {
    map[row][column] = null;
  }

  public void breed(Organism bug)
  {
    System.out.println(map[bug.getRow()][bug.getColumn()]);

  	//first get the hashmap of nearby neighbors
    HashMap<String, Organism> neighbors = getNeighbors(bug.getRow(), bug.getColumn());

    for(Map.Entry<String, Organism> entry : neighbors.entrySet()) {
    String key = entry.getKey();
    Organism value = entry.getValue();
    System.out.println("key " + key + " value " + value);

    if(value == null)
    {
      int[] change = new int[2];
      change = convertString(key);
      int row = bug.getRow() + change[0];
      int column = bug.getColumn() + change[1];
      System.out.println("adding bug to " + row + " " + column);
      map[row][column] = bug.clone(row, column);
      System.out.println(map[bug.getRow()][bug.getColumn()]);

      return;
    }
  }
  }

  //print map
  public void printMap()
 {
 	for(int i = 0; i < 20; i++)
 	{
 		String line = "";
 		for(int j = 0; j < 20; j++)
 		{
 			if(map[i][j] == null)
 			{
 				line += "-";
 			}
 			else if(map[i][j] instanceof Doodlebug)
 			{
 				line += "X";
 			}
  		else if(map[i][j] instanceof Ant)
  		{
    		line += "o";
  		}
    }
 		System.out.println(line);
  }
 }

 //convert from String (up down left right) to int array ([-1,0] [1,0]...)
 public int[] convertString(String movement)
 {
   int[] change = new int[2];
   //default change
   change[0] = 0;
   change[1] = 0;

   switch(movement)
   {
     case "up":
      change[0] = -1;
      break;
     case "down":
      change[0] = 1;
      break;
     case "left":
      change[1] = -1;
      break;
     case "right":
      change[1] = 1;
      break;
   }
   return change;
 }

 public void moveBug(Organism bug)
 {
   HashMap<String, Organism> neighbors = getNeighbors(bug.getRow(), bug.getColumn());
   String move = bug.move(neighbors);
   System.out.println(move);
   int[] change = new int[2];
   change = convertString(move);
   int row = bug.getRow() + change[0];
   int column = bug.getColumn() + change[1];
   if(move == "")
   {
     return;
   }
   else
   {
     //the bug can move to new space, lets set the row and column
     bug.setRow(row);
     bug.setColumn(column);
     removeBug(bug.getRow(), bug.getColumn());
     setSpace(row, column, bug);
   }
  }

  public void start()
  {
    List<Doodlebug> doodlebugs = new ArrayList<Doodlebug>();
    List<Ant> ants = new ArrayList<Ant>();
    for(int i = 0; i < 20; i++)
    {
      for(int j = 0; j < 20; j++)
      {
        Object currentSpace = map[i][j];
        if(currentSpace instanceof Doodlebug)
        {
          doodlebugs.add((Doodlebug) currentSpace);
        }
        else if(currentSpace instanceof Ant)
        {
          ants.add((Ant) currentSpace);
        }
      }
    }
    for(Doodlebug doodlebug : doodlebugs)
    {
      System.out.println(doodlebug);
    }

  }
}
