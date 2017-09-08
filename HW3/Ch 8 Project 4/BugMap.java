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
}
