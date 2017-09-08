import java.util.Random;

public class Organism
{
  private int breed_count, column, row;

  //constructors
  Organism(int x, int y)
  {
    this.column = x;
    this.row = y;
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

  public void setBreedCount(int count)
  {
    this.breed_count = count;
  }
}
