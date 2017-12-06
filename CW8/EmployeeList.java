import java.util.LinkedList;

public class EmployeeList
{

  LinkedList<Employee> employees;

  public EmployeeList()
  {
    employees = new LinkedList<Employee>();
  }


  public LinkedList<Employee> reversedOrder()
  {
	LinkedList<Employee> temp = new LinkedList<Employee>();
    ListIterator<Employee> list = employees.listIterator();
    while(list.hasNext())
    {
    	temp.addFirst(list.next());
    }
    return temp;
  }

  public EmployeeList removeEveryOther()
  {
	  for( int i = 0; i < employees.size(); i += 2)
	  {
		  employees.remove(i)
	  }
  }

  public void draw()
  {
	  ListIterator<Employee> list = employees.listIterator();
	  while(list.hasNext())
	  {
		  System.out.prinln("________________");
		  System.out.prinln("|" + list.next().getName() + "|");
		  System.out.prinln("________________");
		  System.out.println("      ||       ");
		  System.out.println("      ||       ");
		  System.out.println("     \  /      ");
		  System.out.println("      \/       ")
	  }
  }

  public void displayTotal()
  {
	  ListIterator<Employee> list = employees.listIterator();
	  double totalSalary = 0;
	  double totalBonus = 0;
	  while(list.hasNext())
	  {
		  totalSalary += list.next().getSalary();
		  totalBonus += list.next().getBonus();
	  }
	  System.out.println( "total is "  totalSalary * 12 + totalBonus );
  }

  @Override
  public String toString()
  {
    Sting temp = "";
    ListIterator<Employee> list = employees.listIterator();
	  while(list.hasNext())
	  {
      temp += ", " + list.next().getName();
    }
    return temp; 
  }
}
