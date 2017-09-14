import java.util.HashMap;
import java.util.Map;

public class Doodlebug extends Organism
{
  private int starve_count = 0;

  Doodlebug(int x, int y)
  {
    super(x, y);
    this.starve_count = 0;
  }

  Doodlebug(Doodlebug doodle)
  {
    super(doodle.getRow(), doodle.getColumn());
    this.starve_count = 0;
  }

  //accessors and mutators
  public int getStarveCount()
  {
    return this.starve_count;
  }

  public void incrementStarveCount()
  {
    this.starve_count++;
  }

  public void ateAnt()
  {
  	this.starve_count = 0;
  }

  @Override
  public Doodlebug clone(int row, int column)
  {
    return new Doodlebug(row, column);
  }

  @Override
  public String move(HashMap<String, Organism> neighbors)
  {
    Boolean he_ate = false;
    //first get the hashmap of nearby neighbors

    for(Map.Entry<String, Organism> entry : neighbors.entrySet()) {
      String key = entry.getKey();
      Organism value = entry.getValue();
      if(value instanceof Ant)
      {
        he_ate = true;
        return key;
      }
    }
    return "";
  }
}
