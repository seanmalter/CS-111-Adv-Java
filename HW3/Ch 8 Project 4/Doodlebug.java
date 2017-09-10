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
}
