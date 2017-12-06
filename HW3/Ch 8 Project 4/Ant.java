import java.io.Serializable;

public class Ant extends Organism implements Serializable
{
  //default constructs an organism
  Ant(){
    super();
  }

  //clone method for Ant
  @Override
  public Ant clone(){
    return new Ant();
  }
}
