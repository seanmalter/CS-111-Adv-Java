public class LinkedList<T extends Comparable>
{

  public static void main(String[] args)
  {
    LinkedList<Integer> list = new LinkedList<Integer>();
    list.addSorted(1);
    list.addSorted(5);
    list.addSorted(4);
    list.addSorted(7);
    list.addSorted(6);
    list.addSorted(4);

    System.out.println(list);
    
    LinkedList<String> list2 = new LinkedList<String>();
    list2.addSorted("Apple");
    list2.addSorted("Pear");
    list2.addSorted("Banana");
    list2.addSorted("Orange");
    list2.addSorted("Lemon");
    list2.addSorted("Potato");
    System.out.println(list2);
  }

  private class Node<T>
  {
    private T data;
    private Node<T> link;
    public Node( )
    {
      data = null;
      link = null;
    }
    public Node (T newData, Node<T> linkValue)
    {
      data = newData;
      link = linkValue;
    }
  }//End of Node<T> inner class
  private Node<T> head;
  public LinkedList( )
  {
  head = null;
  }
  /**
  24 Adds a node at the start of the list with the specified data.
  25 The added node will be the first node in the list.
  26 */
  public void addToStart(T itemData)
  {
    head = new Node<T> (itemData, head);
  }

  public void addSorted(T itemData)
  {
    //null list check
    if(head == null)
    {
      head = new Node<T>(itemData, null);
      return;
    }
    Node<T> position = head;
    //check start if smaller
    if(itemData.compareTo(head.data) < 0)
    {
      head = new Node<T>(itemData, position);
      return;
    }

    while (position != null)
    {
      //check if at the end of the list
      if(position.link == null)
      {
        position.link = new Node<T>(itemData, null);
        return;
      }
      else if(position.data.compareTo(itemData) <= 0 && position.link.data.compareTo(itemData) >= 0)
      {
        //insert into this spot
        Node tempNode = new Node(itemData, position.link);
        position.link = tempNode;
        return;
      }
      else
      position = position.link;
    }
    System.out.println("unable to add to list");
  }
  /**
  32 Removes the head node and returns true if the list contains at
  33 least one node. Returns false if the list is empty.
  34 */
  public boolean deleteHeadNode( )
  {
    if (head != null)
    {
      head = head.link;
      return true;
    }
    else
    return false;
  }
  /**
  This linked list holds objects of type T.
  The type T should have well-defined
  equals and toString methods.
  46 Returns the number of nodes in the list.
  47 */
  @Override
  public String toString()
  {
    if(head == null)
    {
      return "";
    }
    else
    {
      String returnString = "";
      Node position = head;
      while(position != null)
      {
        returnString += position.data + " ";
        position = position.link;
      }
      return returnString;
    }
  }
  public int size( )
  {
    int count = 0;
    Node<T> position = head;
    while (position != null)
    {
      count++;
      position = position.link;
    }
    return count;
  }
  public boolean contains(T item)
  {
    return (find(item) != null);
  }
  /**
  64 Finds the first node containing the target item, and returns a
  65 reference to that node. If target is not in the list, null is
  returned.
  66 */
  private Node find(T target)
  {
    Node<T> position = head;
    T itemAtPosition;
    while (position != null)
    {
      itemAtPosition = position.data;
      if (itemAtPosition.equals(target))
      return position;
      position = position.link;
    }
    return null; //target was not found
  }
  /**
  81 Finds the first node containing the target and returns a reference
  82 to the data in that node. If target is not in the list, null is
  returned.
  83 */
  public T findData(T target)
  {
    Node<T> result = find(target);
    if (result == null)
    return null;
    else
    return result.data;
  }
  public void outputList( )
  {
    Node<T> position = head;
    while (position != null)
    {
      System.out.println(position.data);
      position = position.link;
    }
  }
  public boolean isEmpty( )
  {
    return (head == null);
  }
  public void clear( )
  {
    head = null;
  }
  /*
  110 For two lists to be equal they must contain the same data items in
  111 the same order. The equals method of T is used to compare data
  items.
  112 */
  public boolean equals(Object otherObject)
  {
    if (otherObject == null)
    return false;
    else if (getClass( ) != otherObject.getClass( ))
    return false;
    else
    {
      LinkedList<T> otherList = (LinkedList<T>)otherObject;
      if (size( )!= otherList.size( ))
      return false;
      Node<T> position = head;
      Node<T> otherPosition = otherList.head;
      while (position != null)
      {
        if (!(position.data.equals(otherPosition.data)))
        return false;
        position = position.link;
        otherPosition = otherPosition.link;
      }
      return true; //no mismatch was not found
    }
  }
}
