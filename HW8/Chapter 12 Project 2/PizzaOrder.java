public class PizzaOrder
{
  public static void main(String[] args)
  {
    PizzaOrder order = new PizzaOrder();
    order.addPizzaToOrder('s', true, false, false);
    order.addPizzaToOrder('l', false, false, true);
    System.out.println("The total of the pizza order is $" + order.calcCost());

    PizzaOrder order2 = new PizzaOrder();
    order2.addPizzaToOrder('m', true, true, true);
    order2.addPizzaToOrder('m', false, false, false);
    System.out.println("The total of the pizza order is $" + order2.calcCost());
  }
  private static final int MAXPIZZAS = 5;
  private Pizza[] pizzas = new Pizza[MAXPIZZAS];
  private int numPizzas = 0;

  public void addPizzaToOrder(char size, boolean pepperoni, boolean sausage, boolean mushrooms)
  {
    if(numPizzas >= MAXPIZZAS)
    {
      System.out.println("too many pizzas in this order, cannot have more than " + MAXPIZZAS + " pizzas.");
      return;
    }
    else
    {
      Pizza pizza = new Pizza(size, pepperoni, sausage, mushrooms);
      pizzas[numPizzas] = pizza;
      numPizzas++;
    }
  }

  public double calcCost()
  {
    double total = 0;
    //small = 8 med = 10, large = 12, $1 per topping.
    for(int i = 0; i < numPizzas; i++)
    {
      switch(pizzas[i].getSize())
      {
        case 's':
          total += 8;
          break;
        case 'm':
          total += 10;
          break;
        case 'l':
          total += 12;
          break;
      }
      total += pizzas[i].getNumToppings();
    }
    return total;
  }
}
