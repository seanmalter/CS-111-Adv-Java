import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;


public class BugMap
{
  Organism[][] map;
  BugMap()
  {
    System.out.println("created a new map");
    map = new Organism[20][20];

    int doodlebugCount = 0;
    int antCount = 0;
    Random r = new Random();

    while(doodlebugCount < 5)
    {
      int row = r.nextInt(20);
      int column = r.nextInt(20);
      if(map[row][column] == null)
      {
        map[row][column] = new Doodlebug(row, column);
        doodlebugCount++;
      }
    }

    while(antCount < 100)
    {
      int row = r.nextInt(20);
      int column = r.nextInt(20);
      if(map[row][column] == null)
      {
        map[row][column] = new Ant(row, column);
        antCount++;
      }
    }
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

  public void removeBug(Organism bug)
  {
    map[bug.getRow()][bug.getColumn()] = null;
  }

  public void breed(Organism bug)
  {
  	//first get the hashmap of nearby neighbors
    HashMap<String, Organism> neighbors = getNeighbors(bug.getRow(), bug.getColumn());

    for(Map.Entry<String, Organism> entry : neighbors.entrySet()) {
    String key = entry.getKey();
    Organism value = entry.getValue();

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

  public boolean it_ate(Doodlebug doodlebug)
  {
    String direction = "";
    Boolean he_ate = false;
    //first get the hashmap of nearby neighbors
    HashMap<String, Organism> neighbors = getNeighbors(doodlebug.getRow(), doodlebug.getColumn());

    for(Map.Entry<String, Organism> entry : neighbors.entrySet()) {
      String key = entry.getKey();
      Organism value = entry.getValue();
      if(value instanceof Ant)
      {
        direction = key;
        he_ate = true;
        break;
      }
    }
    int[] move = convertString(direction);
    int row = doodlebug.getRow() + move[0];
    int column = doodlebug.getColumn() + move[1];
    removeBug(doodlebug);
    setSpace(row, column, doodlebug);
    return he_ate;
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
     removeBug(bug);
     bug.setRow(row);
     bug.setColumn(column);
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
      if(doodlebug.getStarveCount() >= 3)
      {
        removeBug(doodlebug);
        continue;
      }
      else if(it_ate(doodlebug))
      {
        doodlebug.ateAnt();
      }
      else
      {
        moveBug(doodlebug);
        doodlebug.incrementStarveCount();
      }

      if(doodlebug.getBreedCount() >= 8)
      {
        breed(doodlebug);
      }
      doodlebug.incrementBreedCount();
    }
    for(Ant ant : ants)
    {
    	//check if ant got eaten
    	if(map[ant.getRow()][ant.getColumn()] == null)
    	{
    		continue;
    	}
    	else
    	{
    		moveBug(ant);
    		if(ant.getBreedCount() >= 3)
    		{
    			breed(ant);
    		}
    		ant.incrementBreedCount();
    	}
    }
    printMap();
    System.out.println();
  }
}
