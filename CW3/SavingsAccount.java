import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Arrays;
import java.util.ArrayList;

public class SavingsAccount
{
	private int MAX_COINS = 20;
	private ArrayList<Integer> coins = new ArrayList<Integer>();
	private ArrayList<String> names = new ArrayList<String>();
		
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
			System.exit(0);
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
			System.exit(0);
		}
		
		try
		{
			System.out.println("enter the name of the coin, ie penny, nickel, dime");
			Scanner inputofUser = new Scanner(System.in);
			String input = inputofUser.next();
			//checks to see if coin name is valid ie. in coinNames list
			String[] coinNames = {"penny", "nickel", "dime", "quarter"};
			if(Arrays.asList(coinNames).indexOf(input)== -1)
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