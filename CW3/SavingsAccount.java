/*
 Algorithm
Create CoinName and CoinValue Exception classes
Create SavingsAccount class to store all the coins entered into the system
create a method to add coin values to list
create a method to add coin names to list
create a method to print out the total value and coins in the bag
create a main method to run the methods
*/

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Arrays;
import java.util.ArrayList;

public class SavingsAccount
{
	private ArrayList<Integer> coins = new ArrayList<Integer>();
	private ArrayList<String> names = new ArrayList<String>();
	private int currentCoinValue;
	private String currentCoinName;
		
	public static void main(String[] args)
	{
		SavingsAccount purse = new SavingsAccount();
		boolean addMoreValues = true;
		//the most coins a purse can hold
		
		
		while(addMoreValues)
		{
			purse.addCoinValue(0);
			purse.addCoinName(0);
		}
		
	}
	
	public void addCoinValue(int tries)
	{
		if(tries >= 2)
		{
			System.out.println("too many failed attempts, System exit");
			getTotal();
		}
		
		try
		{
			System.out.println("enter a coin value, or type 0 to get the total");
			Scanner inputofUser = new Scanner(System.in);
			int input = inputofUser.nextInt();
			Integer[] coinValues = {1, 5, 10, 25};
			
			if(input == 0)
			{
				getTotal();
			}
			else if(Arrays.asList(coinValues).indexOf(input) == -1)
			{
				throw new CoinValue();
			}
			else
			{
				coins.add(input);
				currentCoinValue = input;
			}
		}
		catch(InputMismatchException e)
		{
			System.out.println("that was not an integer");
			//recursively add tries
			addCoinValue(++tries);
		}
		catch(CoinValue e)
		{
			System.out.printf(e.getMessage() + "%n%n");
		}
	}
	
	public void addCoinName(int tries)
	{
		if(tries >= 2)
		{
			System.out.println("too many failed attempts, System exit");
			getTotal();
		}
		
		try
		{
			System.out.println("enter the name of the coin, ie penny, nickel, dime, quarter");
			Scanner inputofUser = new Scanner(System.in);
			String input = inputofUser.next();
			//checks to see if coin name matches the value
			switch(currentCoinValue)
			{
				case 1:
					currentCoinName = "penny";
					break;
				case 5:
					currentCoinName = "nickel";
					break;
				case 10:
					currentCoinName = "dime";
					break;
				case 25:
					currentCoinName = "quarter";
					break;
					
			}
			
			System.out.println(currentCoinName);
			System.out.println(input);
			
			if(currentCoinName.equals(input))
			{
				//thow coinName exception
				throw new CoinName();
			}
			else
			{
				names.add(input);
			}
		}
		catch(CoinName e)
		{
			System.out.printf(e.getMessage() + "%n%n");
			//recursively add tries
			addCoinName(++tries);
		}
	}
	public void getTotal()
	{
		int pennies = 0, nickels = 0, dimes = 0, quarters = 0;
		for(int coin : coins)
		{
			switch(coin)
			{
				case 1:
					pennies++;
					break;
				case 5:
					nickels++;
					break;
				case 10:
					dimes++;
					break;
				case 25:
					quarters++;
					break;
			}
		}
		int sum = pennies * 1 + nickels * 5 + dimes * 10 + quarters * 25;
		System.out.println("the total amount in the coin bag is " + sum);
		System.out.printf("there are %d pennies, %d nickels, %d dimes, %d quarters%n%n",
		pennies, nickels, dimes, quarters);
		System.exit(0);
	}
}