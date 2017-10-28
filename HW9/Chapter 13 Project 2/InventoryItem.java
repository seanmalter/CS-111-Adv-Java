import java.util.Comparator;
import java.util.Arrays;

public class InventoryItem 
implements Comparable
{

  public static void main(String[] args)
  {
  	InventoryItem[] items = {
  		new InventoryItem("car", 2),
  		new InventoryItem("banana", 4),
  		new InventoryItem("apple", 3),
  		new InventoryItem("sugar", 10),
  		new InventoryItem("ceral", 1)
  	};
  	InventoryItem.sort(items, items.length);
  	//could also use Arrays.sort(items);
  	System.out.println(Arrays.asList(items));
  }
  
  private String name;
  private int uniqueItemID;

  InventoryItem(String name, int ID)
  {
    this.name = name;
    this.uniqueItemID = ID;
  }

  public String getName()
  {
    return name;
  }

  public int getID()
  {
    return uniqueItemID;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public void setID(int ID)
  {
    uniqueItemID = ID;
  }
  
  @Override
  public String toString()
  {
  	return name;
  }

  @Override
  public int compareTo(Object other)
  {
  	InventoryItem temp = (InventoryItem) other;
    if(this.uniqueItemID == temp.uniqueItemID)
    {
      return 0;
    }
    else
    {
      return this.uniqueItemID < temp.uniqueItemID ? -1 : 1;
    }
  }
  
  public static void sort(Comparable[] a, int aLength)
  {
  	int index, indexOfNextSmallest;
  	for(index = 0; index < aLength - 1; index++)
  	{
  		indexOfNextSmallest = indexOfSmallest(index, a, aLength);
  		interchange(index, indexOfNextSmallest, a);
  	}
  }
  
  private static int indexOfSmallest(int startIndex, Comparable[] a, int numberUsed)
  {
  	Comparable min = a[startIndex];
  	int indexOfMin = startIndex;
  	int index;
  	for( index = startIndex + 1; index < numberUsed; index++)
  	{
  		if ( a[index].compareTo(min) < 0)
  		{
  			min = a[index];
  			indexOfMin = index;
  		}
  	}
  	return indexOfMin;
  }
  
  private static void interchange(int i, int j, Comparable[] a)
  {
  	Comparable temp;
  	temp = a[i];
  	a[i] = a[j];
  	a[j] = temp;
  }
}
