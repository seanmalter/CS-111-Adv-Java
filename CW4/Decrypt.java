/*------------------------------------------------------------------------------
**	Course: CS112		Day/Time: Tuesday 5:30PM 
**	Chapter Number:Name 10	File Encryption Filter File Handling
**	Programmer(s): Justin Wahl, Ervin Pedersen, Ruben Martinez, Sean Malter, 
**				   Rusheel Vallabh
**	Date Created or Last Modified:  26SEP2017
**------------------------------------------------------------------------------

**------------------------------------------------------------------------------
**  Program Title: Decrypt
**  Program Description: 
**------------------------------------------------------------------------------

**------------------------------------------------------------------------------
**	ALGORITHM. 	
**
**	1. Prompt user to enter file to decrypt
**	2. Try to create input stream to file
**	3. Throw FileNotFoundException if file does not exist or cannot open
**	4. Prompt user to enter input file name
**	5. Create File object from entered file name
**	6. Try to create input stream from File object
**	7. Throw FileNotFoundException if file does not exist or cannot open
**	8. While input stream has next line, read in line to a variable
**	9. Iterate through characters in line
**	10.Use shift() method on each character, which converts the char to an int
**	   adds 6, takes the modulo 255, converts it back to a char, and returns it
**	11.Print char to output stream
**	12.At the end of the line, print a new line to output stream
**	13.Close input and output streams
**_____________________________________________________________________________
*/
//IMPORTED PACKAGES:import java.util.Scanner;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Decrypt
{
  public static void main(String[] args)
  {
    decryption();
  }
  public static void decryption()
  {
    try
    {
      Scanner keyboard = new Scanner(System.in);
      System.out.println("Please enter file name.");
      String inputFile = keyboard.next();
      
      Scanner fileInputStream = new Scanner(new FileInputStream(inputFile));
      while(fileInputStream.hasNextLine())
      {
        String newLine = fileInputStream.nextLine();
        for(char ch : newLine.toCharArray())
        {
          int ascii = (int) ch;
          
          int newValue = (ascii - 6)%255;
          
          char decryptedChar = (char) newValue;
          System.out.print(decryptedChar);
         
        }
        System.out.print("\n");
      }  
      fileInputStream.close();

    }
    catch(FileNotFoundException e)
    {
      System.out.println(e.getMessage());
    }
  }
}
