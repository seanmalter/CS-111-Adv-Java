import java.util.HashMap;
import java.util.Map;
import java.io.Serializable;


public class Doodlebug extends Organism implements Serializable
{
  //starve count keeps track of when the bug starves
  private int starve_count = 0;

  //default constructor
  Doodlebug()
  {
    super();
    this.starve_count = 0;
  }

  //accessors and mutators
  //retrieve starve count
  public int getStarveCount()
  {
    return this.starve_count;
  }

  //increment starve count by 1
  public void incrementStarveCount()
  {
    this.starve_count++;
  }

  // reset the starve count to 0
  public void resetStarveCount()
  {
  	this.starve_count = 0;
  }

  //clone the doodlebug
  @Override
  public Doodlebug clone()
  {
    return new Doodlebug();
  }
}
