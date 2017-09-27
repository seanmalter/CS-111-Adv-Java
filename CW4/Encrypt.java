/*------------------------------------------------------------------------------
**	Course: CS112		Day/Time: Tuesday 5:30PM 
**	Chapter Number: 10 Name:	File Encryption Filter 
**	Programmer(s): Justin Wahl, Ervin Pedersen, Ruben Martinez, Sean Malter, 
**				   Rusheel Vallabh
**	Date Created or Last Modified:  26SEP2017
**------------------------------------------------------------------------------

**------------------------------------------------------------------------------
**  Program Title: Encrypt
**  Program Description: 
**------------------------------------------------------------------------------

**------------------------------------------------------------------------------
**	ALGORITHM. 	
**
**	1. Prompt user to enter file to encrypt
**	2. Try to create input stream to file
**	3. Throw FileNotFoundException if file does not exist or cannot open
**	4. Prompt user to enter output file name
**	5. Create File object from entered file name
**	6. Try to create output stream to File object
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
//IMPORTED PACKAGES:

import java.io.File;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

//_____________________________________________________________________________
//ACTUAL PROGRAM:

public class Encrypt
{
	public static void main(String[] args)
	{
		Scanner 	inputStream = null;
		PrintWriter	outputStream = null;
		Scanner 	kb = new Scanner(System.in);
		String		inputFile = "";
		File		outputFile = null;
		String		outputName = "";
		String		line = "";
		
		
		System.out.println("Enter file to encrypt: ");
		
		inputFile = kb.next();
		
		try
		{
			inputStream = new Scanner(new FileInputStream(inputFile));
		}
		catch (FileNotFoundException e)
		{
			System.out.println("File " + inputFile + " was not found");
			System.out.println("or could not be opened.");
			System.exit(0);
		}
		
		System.out.println("Enter file to output too: ");
		
		
		outputName = kb.next();
		outputFile = new File(outputName);
		
		
		try
		{
			outputStream = new PrintWriter(new FileOutputStream(outputFile));
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Error opening the file " + outputFile);
			System.exit(0);
		}
		
		while (inputStream.hasNextLine())
		{
			line = inputStream.nextLine();
			
			for (int i = 0; i < line.length(); i++)
			{
				outputStream.print(shift(line.charAt(i)));				
			}
			
			outputStream.print("\n");
			
		}
		
		inputStream.close();
		outputStream.close();
		
	}
	
	public static char shift(char n)
	{
		return (char)(((int)n + 6)%255);
	}
}
