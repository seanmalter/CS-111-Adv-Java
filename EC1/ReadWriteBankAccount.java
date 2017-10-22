import java.io.RandomAccessFile;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.FileNotFoundException;

public class ReadWriteBankAccount
{
  	public static void main(String[] args)
  {
    userInput();
    readBankAccounts();
    readBankAccount(checkAccountName("Sean"));
    readBankAccount(checkAccountNumber(2));
  }

  public static void userInput()
  {
    try
    {
      BankAccount account = new BankAccount();
      account.newTransaction();
      int accountNumber = account.getAccountNumber();

      RandomAccessFile ioStream = new RandomAccessFile("bytedata", "rw");
      int currentByte = 0;
      long fileLength = ioStream.length();
      boolean accountExists = false;
      while(currentByte < fileLength)
      {
        ioStream.seek(currentByte);
        //account exists, update with new data.
        if(ioStream.readInt() == accountNumber)
        {
          accountExists = true;
          ioStream.seek(currentByte + 4 + 17);
          double currentBalance = ioStream.readDouble();
          ioStream.seek(currentByte + 4 + 17);
          ioStream.writeDouble(currentBalance + account.getBalance());
        }
        currentByte += 29; // 28 = byte size of each bank account
      }
      //account doesn't exist, make a new account.
      if (!accountExists)
      {
      	ioStream.seek(fileLength);
      	ioStream.writeInt(account.getAccountNumber()); //size = 4
        ioStream.writeUTF(account.getName()); //size = 17
        ioStream.seek(currentByte + 4 + 17);
        ioStream.writeDouble(account.getBalance()); //size = 8
        //maxsize of each bank account is 29
      }
      ioStream.close();
      System.out.println("make another deposit? Y/n");
      Scanner input = new Scanner(System.in);
      String c = input.next();
      if(c.toLowerCase().equals("y"))
      {
        userInput();
      }
    }
    catch(FileNotFoundException e)
    {
      System.out.println("Problem opening file.");
    }
    catch(IOException e)
    {
      System.out.println("Problems with file I/O.");
    }
  }

  public static long checkAccountName(String name)
  {
    System.out.println("looking for an account that has name: " + name);
    try
    {
      RandomAccessFile ioStream = new RandomAccessFile("bytedata", "rw");
      long currentByte = 0;
      long fileLength = ioStream.length();
      while(currentByte < fileLength)
      {
        ioStream.seek(currentByte + 4);
        //account exists, update with new data.
        if(ioStream.readUTF().equals(name))
        {
          ioStream.close();
          return currentByte;
        }
        currentByte += 29; // 28 = byte size of each bank account
      }
      ioStream.close();
    }
    catch(FileNotFoundException e)
    {
      System.out.println("Problem opening file.");
    }
    catch(IOException e)
    {
      System.out.println("Problems with file I/O.");
    }
    return -1;
  }

  public static long checkAccountNumber(long accountNumber)
  //return the byte location of the account number, or -1 if it desn't exist
  {
    System.out.println("looking for an account with number: " + accountNumber);
    try
    {
      RandomAccessFile ioStream = new RandomAccessFile("bytedata", "rw");
      long currentByte = 0;
      long fileLength = ioStream.length();
      while(currentByte < fileLength)
      {
        ioStream.seek(currentByte);
        //account exists, update with new data.
        if(ioStream.readInt() == accountNumber)
        {
          ioStream.close();
          return currentByte;
        }
        currentByte += 29; // 28 = byte size of each bank account
      }
      ioStream.close();
    }
    catch(FileNotFoundException e)
    {
      System.out.println("Problem opening file.");
    }
    catch(IOException e)
    {
      System.out.println("Problems with file I/O.");
    }
	   return -1;
  }

  public static void writeBankAccount(BankAccount account)
  {
    try
    {
      RandomAccessFile ioStream = new RandomAccessFile("bytedata", "rw");

      long currentByte = ioStream.length();
	    ioStream.seek(currentByte);
      ioStream.writeInt(account.getAccountNumber()); //size = 4
      ioStream.writeUTF(account.getName()); //size = 17
      ioStream.seek(currentByte + 4 + 17);
      ioStream.writeDouble(account.getBalance()); //size = 8
      //maxsize of each bank account is 29
      ioStream.close();
    }
    catch (IOException e) { }
  }

  public static void readBankAccount(long currentByte)
  {
    try
    {
      RandomAccessFile ioStream = new RandomAccessFile("bytedata", "rw");

      ioStream.seek(currentByte);
      System.out.printf("Account Number: %d%n", ioStream.readInt());
      System.out.printf("Name: %s%n", ioStream.readUTF());
      ioStream.seek(currentByte + 4 + 17);
      System.out.printf("Amount: %f%n", ioStream.readDouble()); //format the value to have 2 decimal places
      System.out.println();
    }
    catch(FileNotFoundException e)
    {
      System.out.println("Problem opening file.");
    }
    catch(IOException e)
    {
      System.out.println("Problems with file I/O.");
    }
  }

  public static void readBankAccounts()
  {
    try
    {
      RandomAccessFile ioStream = new RandomAccessFile("bytedata", "rw");

      int currentByte = 0;
      long fileLength = ioStream.length();
      while(currentByte < fileLength)
      {
        ioStream.seek(currentByte);
        System.out.printf("Account Number: %d%n", ioStream.readInt());
        System.out.printf("Name: %s%n", ioStream.readUTF());
        ioStream.seek(currentByte + 4 + 17);
        System.out.printf("Amount: %f%n", ioStream.readDouble()); //format the value to have 2 decimal places
        System.out.println();
        currentByte += 29; // 28 = byte size of each bank account
      }

    }
    catch(FileNotFoundException e)
    {
      System.out.println("Problem opening file.");
    }
    catch(IOException e)
    {
      System.out.println("Problems with file I/O.");
    }
  }
}
