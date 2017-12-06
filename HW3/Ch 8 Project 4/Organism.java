import java.util.Random;
import java.util.HashMap;
import java.util.Map;

public abstract class Organism
{
  //breed count keeps track of when the bug breeds
  // hasMoved keeps track of if the bug has moved this turn
  private int breed_count;
  private Boolean hasMoved = false;

  //default constructor
  Organism()
  {
    this.breed_count = 0;
  }

  //accessors
  //returns the current breed count
  public int getBreedCount()
  {
    return breed_count;
  }

  //gets the has moved boolean to see if a bug has moved this turn
  public Boolean getHasMoved()
  {
    return hasMoved;
  }

//mutators
  //increments breed count by 1
  public void incrementBreedCount()
  {
    this.breed_count++;
  }

  //sets the hasMoved to true after the bug has moved
  public void moved()
  {
    this.hasMoved = true;
  }

  //sets hasMoved to false to reset for the next turn
  public void resetMoved()
  {
    this.hasMoved = false;
  }

  //sets the breed count to zero after the bug breeds
  public void resetBreedCount()
  {
  	this.breed_count = 0;
  }

  //clone for the organism must be implemented on all child classes
  public abstract Organism clone();

}
