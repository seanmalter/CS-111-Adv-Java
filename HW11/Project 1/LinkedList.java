public class LinkedList
{
  private Suitor head;
  private int count = 0;

  public LinkedList()
  {
    head = null;
  }
  public void addToStart(String name, int itemCount)
  {
    head = new Suitor(name, itemCount, head);
    count++;
  }
  public void deleteNode(int index)
  {
    if(index == 0)
    {
      head = head.getLink();
      count--;
    }
    else if(index >= count)
    {
      System.out.println("connot delete that item, " + index + " is out of the range");
    }
    else
    {
      Suitor previousPosition = null;
      Suitor position = head;
      int i = 0;
      while (i < index)
      {
        previousPosition = position;
        position = position.getLink();
        i++;
      }
      previousPosition.setLink(position.getLink());
      count--;
    }
  }
  public int getCount()
  {
    return count;
  }
  @Override
  public String toString()
  {
    String printed = "";
    Suitor position = head;
    while(position != null)
    {
      printed += position.getName() + ", at position " + position.getCount() + ", ";
      position = position.getLink();
    }
    return printed;
  }
}
