import java.util.Scanner;

public class Employee
{
  public static void main(String[] args)
  {
    int MAX_EMPLOYEES = 100;
    Scanner s = new Scanner(System.in);

    Employee[] employees = new Employee[MAX_EMPLOYEES];
    for(int i=0; i < employees.length; i++)
    {
      Employee newEmployee = new Employee();
      s.nextLine();
      System.out.println("Enter employee's name (type 'n' to exit)");
      String name = s.nextLine();
      if(name.toLowerCase().equals("n"))
      {
        break;
      }
      else
      {
        newEmployee.setName(name);
      }
      System.out.println("Enter employee's title");
      newEmployee.setTitle(s.nextLine());
      System.out.println("Enter employee's salary");
      newEmployee.setSalary(s.nextDouble());
      s.nextLine(); //hack to not skip the SSN
      System.out.println("Enter employee's SSN");
      newEmployee.setSSN();

      newEmployee.employeeInfo(200);

      //add new employee to employees array
      employees[i] = newEmployee;
    }
  }

  private String name, title, SSN;
  private double salary;
  Scanner s = new Scanner(System.in);

  Employee() { }

  Employee(String name, String title, String SSN, double salary)
  {
    this.name = name;
    this.title = title;
    this.SSN = SSN;
    this.salary = salary;
  }

  public String getName()
  {
    return name;
  }

  public String getTitle()
  {
    return title;
  }

  public String getSSN()
  {
    return SSN;
  }

  public double getSalary()
  {
    return salary;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public void setTitle(String title)
  {
    this.title = title;
  }

  public void setSalary(double salary)
  {
    this.salary = salary;
  }

  public void setSSN()
  {
    String SSN = s.nextLine();
    try
    {
      if(SSN.length() < 9 || SSN.length() > 9)
      {
        throw new SSNLengthException();
      }
      else
      {
        for(int i = 0; i < SSN.length(); i++)
        {
          if(!Character.isDigit(SSN.charAt(i)))
          {
            throw new SSNCharacterException();
          }
        }
        this.SSN = SSN;
      }
    }
    catch(SSNLengthException e)
    {
      System.out.println(e.getMessage());
      setSSN();
    }
    catch(SSNCharacterException e)
    {
      System.out.println(e.getMessage());
      setSSN();
    }
  }

  public void employeeInfo(double average)
  {
    String compareAve;
    if(salary < average)
    {
      compareAve = "below average";
    }
    else if(salary > average)
    {
      compareAve = "above average";
    }
    else
    {
      compareAve = "is the average";
    }
    System.out.printf("Employee: %s Title: %s SSN: %s Salary: %s%n", name, title, SSN, compareAve);
  }
}
