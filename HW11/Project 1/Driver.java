public class Driver
{

  public static void main(String[] args) {
    LinkedList suitorList = new LinkedList();
    suitorList.addToStart("Bart Simpson", 7);
    suitorList.addToStart("James Dean", 6);
    suitorList.addToStart("Jimmy Neutron", 5);
    suitorList.addToStart("Louis Stevens", 4);
    suitorList.addToStart("Alladin", 3);
    suitorList.addToStart("Jafar", 2);
    suitorList.addToStart("Odie", 1);

    int counter = 0;
    int shiftingIndex = 0;
    while(suitorList.getCount() > 1)
    {
      if(counter%3 == 2)
      {
        suitorList.deleteNode(shiftingIndex%suitorList.getCount());
        shiftingIndex--;
      }
      counter++;
      shiftingIndex = (shiftingIndex + 1)%suitorList.getCount();
    }
    
    System.out.println("the person chosen by the princess is " + suitorList);
  }
}
