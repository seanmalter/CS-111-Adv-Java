import java.util.Scanner;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.EOFException;

public class ReadWrite
{
  public static void main(String[] args)
  {
  	Scanner sc = new Scanner(System.in);
    System.out.println("Type 'read' or 'write' to read the pet file or write a"+
    " new pet file");
    String choice = sc.next();
    ReadWrite rw = new ReadWrite();
    rw.readOrWrite(choice);
  }

  private PetRecord oldestPet = null;
  private PetRecord youngestPet = null;
  private PetRecord heaviestPet = null;
  private PetRecord lightestPet = null;

  public void readOrWrite(String readOrWrite)
  {
    if(readOrWrite.toLowerCase().equals("read"))
    {
      readFile();
    }
    else if(readOrWrite.toLowerCase().equals("write"))
    {
      writeFile();
    }
    else
    {
      System.err.println("That was not an option");
    }
  }

  public static void writeFile()
  {
    Scanner sc = new Scanner(System.in);
    try
    {
      System.out.println("Enter the file name to write");
      String fileName = sc.next();
      ObjectOutputStream outputStream =
        new ObjectOutputStream(new FileOutputStream(fileName));

      boolean continuePetRecords = true;
      while(continuePetRecords)
      {
        System.out.println("Enter your pet's name");
        String name = sc.next();
        System.out.println("Enter your pet's age");
        int age = sc.nextInt();
        System.out.println("Enter your pet's weight");
        double weight = sc.nextDouble();
        PetRecord newRecord = new PetRecord(name, age, weight);
        outputStream.writeObject(newRecord);
        System.out.println("Continue? (Y/n)");
        if(!sc.next().toLowerCase().equals("y"))
        {
          continuePetRecords = false;
        }
      }
      outputStream.close();
    }
    catch(IOException e)
    {
      System.out.println(e.getMessage());
    }
  }

  public void readFile()
  {
    Scanner sc = new Scanner(System.in);
    try
    {
      ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("petRecord"));
      try
      {
        while(true)
        {
          PetRecord newRecord = (PetRecord) inputStream.readObject();
          newRecord.writeOutput();
          oldestYoungest(newRecord);
          heaviestLightest(newRecord);
          System.out.println("Press \"Enter\" to continue");
          sc.nextLine();
        }
      }
      catch(EOFException e) {}
      inputStream.close();
      System.out.println("the oldest pet is " + oldestPet.getName() + " at " +
      oldestPet.getAge() + " years old");
      System.out.println("the youngest pet is " + youngestPet.getName() + " at " +
      youngestPet.getAge() + " years old");
      System.out.println("the heaviest pet is " + heaviestPet.getName() + " at " +
      oldestPet.getWeight() + " lbs");
      System.out.println("the lightest pet is " + lightestPet.getName() + " at " +
      lightestPet.getWeight() + " lbs");

    }
    catch(FileNotFoundException e)
    {
      System.out.println(e.getMessage());
    }
    catch(ClassNotFoundException e)
    {
      System.out.println(e.getMessage());
    }
    catch(IOException e)
    {
      System.out.println(e.getMessage());
    }
  }

  public void oldestYoungest(PetRecord pet)
  {
    int age = pet.getAge();
    if(youngestPet == null)
    {
      youngestPet = pet;
    }
    else if(oldestPet == null)
    {
      oldestPet = pet;
    }
    else if(youngestPet.getAge() > age)
    {
      youngestPet = pet;
    }
    else if(oldestPet.getAge() < age)
    {
      oldestPet = pet;
    }
  }

  public void heaviestLightest(PetRecord pet)
  {
    double weight = pet.getWeight();
    if(lightestPet == null)
    {
      lightestPet = pet;
    }
    else if(heaviestPet == null)
    {
      heaviestPet = pet;
    }
    else if(lightestPet.getWeight() > weight)
    {
      lightestPet = pet;
    }
    else if(heaviestPet.getWeight() < weight)
    {
      heaviestPet = pet;
    }
  }

}
