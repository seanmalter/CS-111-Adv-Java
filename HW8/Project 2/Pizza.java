public class Pizza
{
  private boolean pepperoni, sausage, mushrooms;
  private char size;

  Pizza(char size, boolean pepperoni, boolean sausage, boolean mushrooms)
  {
    this.size = size;
    this.pepperoni = pepperoni;
    this.sausage = sausage;
    this.mushrooms = mushrooms;
  }

  public char getSize()
  {
    return size;
  }

  public int getNumToppings()
  {
    int toppings = 0;
    if(pepperoni)
    {
      toppings++;
    }
    if(sausage)
    {
      toppings++;
    }
    if(mushrooms)
    {
      toppings++;
    }
    return toppings;
  }
}
