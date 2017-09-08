import java.util.HashMap;

public class BugMap
{
  Organism[][] map;
  BugMap()
  {
    System.out.println("created a new map");
    map = new Organism[20][20];
    map[1][1] = new Organism(1,1);
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
      neighbors.put("top", map[row - 1][column]);
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
      neighbors.put("bottom", map[row + 1][column]);
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
  	//first get the hashmap of nearby neighbors
    HashMap<String, Organism> neighbors = bug.getNeighbors(bug.getRow(), bug.getColumn());

    neighbors.forEach((position, neighbor) ->
    if(!neighbor instanceof Organism)
    {
      switch(position)
      {
        case "Top":
          return;
        case "Left":
        case "Right":
        case "Bottom":
      }
    })
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
 			else if(map[i][j] instanceof Organism)
 			{
 				line += "X";
 			}
 		}
 		System.out.println(line);
 	}
 }
}
