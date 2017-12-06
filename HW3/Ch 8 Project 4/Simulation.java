import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.io.Serializable;

// this class contains almost all the logic for moving, eating and breeding bugs
//
public class Simulation implements Serializable
{
  //this map holds the bugs in a 2d array
  private Organism[][] map;
  //constants for the map size and number of bugs
  private int MAP_SIZE = 20;
  private int NUM_DOODLEBUGS = 15;
  private int NUM_ANTS = 25;

  //inner class that is an exception for when too many bugs are on the map1
  private class BugSizeException extends Error
  {
    BugSizeException()
    {
      super("too many bugs for the size of the map");
    }
  }

  //initialize new simulation and places bugs in random starting locations
  Simulation() throws BugSizeException
  {
    System.out.println("created a new map");
    map = new Organism[MAP_SIZE][MAP_SIZE];

    int doodlebugCount = 0;
    int antCount = 0;
    Random r = new Random();

    // check if there are enough spaces for bugs, if not throw exception
    if(NUM_ANTS + NUM_DOODLEBUGS > MAP_SIZE * MAP_SIZE)
    {
      System.out.println("there are too many bugs to fit in the map");
      throw new BugSizeException();
    }

    //try to place the bug in a random spot, continue
    //until we have the num doodlebugs
   while(doodlebugCount < NUM_DOODLEBUGS)
   {
     int row = r.nextInt(MAP_SIZE);
     int column = r.nextInt(MAP_SIZE);
     if(map[row][column] == null)
     {
       map[row][column] = new Doodlebug();
       doodlebugCount++;
     }
   }

   //put ants on the map until we have the num ants on the map
   while(antCount < NUM_ANTS)
   {
     int row = r.nextInt(MAP_SIZE);
     int column = r.nextInt(MAP_SIZE);
     if(map[row][column] == null)
     {
       map[row][column] = new Ant();
       antCount++;
     }
   }
 }


  //print map, iterate through each map spot
  public void printMap()
  {
    for(int i = 0; i < map.length; i++)
    {
      String line = "";
      for(int j = 0; j < map[0].length; j++)
      {
        //put blank spot on map
        if(map[i][j] == null)
        {
          line += "-";
        }
        //put an X for the doodlebug
        else if(map[i][j].getClass() == Doodlebug.class)
        {
          line += "X";
        }
        //put an o for the ant
        else if(map[i][j].getClass() == Ant.class)
        {
          line += "o";
        }
      }
      //prints out the map, line by line
      System.out.println(line);
    }
  }

  //used for moving the bugs, tries to move to random spot,
  //if the spot is occoupied or out of bounds don't move
  public void randomMove(int row, int column)
  {
    //get a random spot around the bug
    Random r = new Random();
    int changeRow = r.nextInt(3) - 1;
    int changeCol = r.nextInt(3) - 1;
    try
    {
      //check if the new spot is null, if so move there
      if(map[row + changeRow][column + changeCol] == null)
      {
        map[row + changeRow][column + changeCol] = map[row][column];
        map[row][column] = null;
      }
    }
    //catch if the new spot is outside the array
    catch(ArrayIndexOutOfBoundsException e)
    {
    }
  }

  //looks at the neighbors of the spot, and returns an arraylist of
  // strings that have the row,col of empty spots as the entries
  private ArrayList<String> getEmptyNeighbors(int row, int col)
  {
    //stores the location of empty locations
    ArrayList<String> emptyNeighbors = new ArrayList<String>();
    //loop through the rows (i) and columns (j)
    for( int i = row - 1; i <= row + 1; i++)
    {
      for( int j = col - 1; j <= col + 1; j++ )
      {
        try
        {
          // don't let the bug move using the -1 element of the array
          if(i <= -1 || j <= -1)
          {
            continue;
          }
          //if the location is empty add it to the arraylist
          if(map[i][j] == null)
          {
            String locationStr = i + "," + j;
            emptyNeighbors.add(locationStr);
          }
        }
        //catch any locations that are outside of the map
        catch(ArrayIndexOutOfBoundsException e) { continue; }
      }
    }
    //return the arraylist of empty spots
    return emptyNeighbors;
  }

  //gets the neighbors that are ants and adds them to
  //the hashmap to map these neighbors locations
  private HashMap<String, Organism> getNeighbors(int row, int col)
  {
    //this holds the ants that are within eating range
    HashMap<String, Organism> neighbors = new HashMap<String, Organism>();
    //loop through the rows (i) and columns (j)
    for( int i = row - 1; i <= row + 1; i++)
    {
      for( int j = col - 1; j <= col + 1; j++ )
      {
        try
        {
          //don't look at the opposite side of the map
          if(i <= -1 || j <= -1)
          {
            continue;
          }
          // check to see if there is an ant at (i,j), if so add it to the hashmap
          if(map[i][j] != null && map[i][j].getClass() == Ant.class)
          {
            String locationStr = i + "," + j;
            neighbors.put(locationStr, map[i][j]);
          }
        }
        //catch any locations that are outside the map
        catch(ArrayIndexOutOfBoundsException e)
        {
        }
      }
    }
    //return the hashmap of all the bugs and their locations
    return neighbors;
  }

  //doodlebug tries to eat a nearby ant, returns true if he ate an ant
  public boolean ateNeighbor(int row, int col)
  {
    //get neighboring ants that the doodlebug can eat
    HashMap<String, Organism> neighbors = getNeighbors(row, col);
    //if there are no neighbors then the bug cant eat, return false
    if(neighbors.isEmpty())
    {
      //the doodlebug didn't eat
      return false;
    }
    //there is a neighbor that the bug can eat
    else
    {
      //get a random key from the hashmap to eat that bug
      List<String> keys = new ArrayList<String>(neighbors.keySet());
      Random r = new Random();
      //takes the location key string and breaks it up to have <array> [row, col]
      String[] locationStr = keys.get(r.nextInt(keys.size())).split(",");
      int[] locationArr = new int[2];
      try
      {
        //try to parse the location string key to get the row and column of the ants
        //that gets eaten
        locationArr[0] = Integer.parseInt(locationStr[0]);
        locationArr[1] = Integer.parseInt(locationStr[1]);
      }
      //catch error if the location string cannot be parsed
      catch(NumberFormatException e)
      {
        //the doodlebug didn't eat
        return false;
      }

      //move doodlebug to the ant's location and set doodlebugs location to null
      map[locationArr[0]][locationArr[1]] = map[row][col];
      map[row][col] = null;
      return true;
    }
  }

  //this is the main function to call all the other
  //pieces and moves that a bug can do each time step
  public void timeStep()
  {
    //loop through the rows (i) and columns (j)
    for(int i = 0; i < map.length; i++)
    {
      for(int j = 0; j < map[0].length; j++)
      {
        //no bug in this spot, go to next spot
        if(map[i][j] == null)
        {
          continue;
        }
        //doodlebug procedure
        else if(map[i][j].getClass() == Doodlebug.class)
        {
          //get the doodlebug and set to tempbug to manipulate
          Doodlebug tempBug = (Doodlebug) map[i][j];
          //check if the bug already moved
          if(tempBug.getHasMoved())
          {
            continue;
          }
          //the doodlebug starves
          else if(tempBug.getStarveCount() >= 5)
          {
            //set his spot to null
            map[i][j] = null;
          }
          //check to see if doodlebug ate an ant this turn
          else if(ateNeighbor(i,j))
          {
            //set starve count to 0
            tempBug.resetStarveCount();
          }
          //he didn't eat, so move him to random location
          else
          {
            randomMove(i, j);
          }
          //check to see if he needs to breed
          if(tempBug.getBreedCount() >= 6)
          {
            breed(i, j, Doodlebug.class);
            tempBug.resetBreedCount();
          }
          //increment starve count and breed count
          tempBug.incrementStarveCount();
          tempBug.incrementBreedCount();
        }
        //ant procedure
        else if(map[i][j].getClass() == Ant.class)
        {
          //set tempbug as an ant in col i, row j
          Ant tempBug = (Ant) map[i][j];
          //see if the ant needs to breed
          if(tempBug.getBreedCount() >= 3)
          {
            //breed ant and reset breed count to 0
            breed(i,j, Ant.class);
            tempBug.resetBreedCount();
          }
          //if the bug hasn't moved, move the bug and increment breed count
          if(!tempBug.getHasMoved())
          {
            randomMove(i,j);
            tempBug.incrementBreedCount();
            tempBug.moved();
          }
        }
      }
    }

    //reset all moved bools on bugs
    for(int i = 0; i < map.length; i++)
    {
      for(int j = 0; j < map[0].length; j++)
      {
        //check for a bug in the spot (i, j)
        if(map[i][j] != null)
        {
          //typecast the bug as an organism and reset the hasMoved boolean
          Organism tempBug = map[i][j];
          tempBug.resetMoved();
        }
      }
    }
  }

  //Organism tries to breed, if no open spots are available
  //the organism doesn't breed, bugType is used for cloning
  private void breed(int row, int col, Class bugType)
  {
    //finds what spots the bug can breed a new bug
    ArrayList<String> emptyNeighbors = getEmptyNeighbors(row, col);
    if(emptyNeighbors.isEmpty())
    {
      //there are no empty spots, return
      return;
    }
    //there is a spot to breed
    else
    {
      Random r = new Random();
      //takes the location key string and breaks it up to have <array> [row, col]
      String[] locationStr = emptyNeighbors.get(r.nextInt(emptyNeighbors.size())).split(",");
      int[] locationArr = new int[2];
      try
      {
        //tries to parse the location string as two integers
        locationArr[0] = Integer.parseInt(locationStr[0]);
        locationArr[1] = Integer.parseInt(locationStr[1]);
      }
      //catch the exception that the location string cannot be parsed
      catch(NumberFormatException e)
      {
        return;
      }
      try
      {
        //creates a new instance of the bug
        map[locationArr[0]][locationArr[1]] = (Organism) bugType.newInstance();
      }
      //catch any exception that might happen from breed
      catch(Exception e) {}
    }
  }
}
