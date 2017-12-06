import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenericArrayList<T>
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("enter 'String', 'Integer', 'Double' to initialize the array list");
		String selection = input.nextLine();
		List list = new ArrayList();
		boolean resume = true;
		
		
		while(resume)
		{
			System.out.println("Enter a value of the type " + selection + ", type p to print the list");
			
			switch(selection.toLowerCase()) {
			case "string":
				String temp1 = input.nextLine();
				list.add(temp1);			
				break;
			case "integer":
				Integer temp2 = input.nextInt();
				input.nextLine();
				list.add(temp2);
				break;
			case "double":
				Double temp3 = input.nextDouble();
				input.nextLine();
				list.add(temp3);
				break;
			case "p":

				
				break;
			default:
				System.out.println("that was not a choice.");
				break;
			}
			
			System.out.println("continue? Y / n ?");
			if(input.nextLine().toLowerCase().equals("n"))
			{
				resume = false;
				System.out.println();
				for(Object item : list)
				{
					System.out.print(item + ", ");
				}
			}
		}

		
		input.close();
	}
}
