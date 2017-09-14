import java.util.Random;
import java.util.HashMap;
import java.util.Map;

public abstract class Organism
{
  private int breed_count, column, row;

  //constructors
  Organism(int x, int y)
  {
    this.column = x;
    this.row = y;
    this.breed_count = 0;
  }

  Organism(Organism bug)
  {
    this.column = bug.getColumn();
    this.row = bug.getRow();
    this.breed_count = 0;
  }

//accessors
  public int getRow()
  {
    return row;
  }

  public int getColumn()
  {
    return column;
  }

  public int getBreedCount()
  {
    return breed_count;
  }

//mutators
  public void setRow(int x)
  {
    this.column = x;
  }

  public void setColumn(int y)
  {
    this.row = y;
  }

  public void incrementBreedCount()
  {
    this.breed_count++;
  }

  public void resetBreedCount()
  {
  	this.breed_count = 0;
  }

  //clone
  public abstract Organism clone(int row, int column);

  //move (like an ant)
  public String move(HashMap<String, Organism> neighbors)
  {
    Random r = new Random();
    int rng = r.nextInt(4);
    int count = 0;

    //map the values to values array, and the strings to keys
    //if count == rng then the ant tries to move there
    for(Map.Entry<String, Organism> entry : neighbors.entrySet()) {
      if(count == rng)
      {
        String key = entry.getKey();
        Organism value = entry.getValue();
        if(value == null)
        {
          return key;
        }
      }
      count++;
    }
    return "";
  }
}
