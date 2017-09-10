public class Ant extends Organism
{
  Ant(int row, int column){
    super(row, column);
  }

  //clone method
  @Override
  public Ant clone(int row, int column){
    return new Ant(row, column);
  }
}
