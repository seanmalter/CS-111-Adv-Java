/* Chapter No. 8 Exercise No. 3
   File Name: Rental.java
   Programmer: Sean Malter
   Date Last Modified: September 4, 2017

   Problem Statement: I want to implement a Movie class to store movie information
   and 

   Overall Plan (Algorithm - step-by-step plan to make it happen):
   1. Build the Rental class
   2. Create constructor to initialize a rented movie
   3. Late fees method in the class to return the cost of late fees
   4. create an array of type Rental filled with sample data of all types of movies
   5. create a method named lateFeesOwed that iterates through the array and
    returns the total amount of late fees that are outstanding.

   Classes needed and Purpose (Input, Processing, Output)
   Movie
   Action
   Drama
   Comedy
   Rental
*/

public class Rental extends Movie
{
	
	public static void main(String[] args)
	{
		Movie movie = new Movie(1,"PG", "Lion King");
		Rental rental1 = new Rental(movie, 4, 2);
		System.out.printf("the late fee for %s is $%f%n", movie.getTitle(), rental1.late_fees());
		
		Action action = new Action(1, "PG", "Not Lion King");
		Rental rental2 = new Rental(action, 4, 2);
		System.out.printf("the late fee for %s is $%f%n", action.getTitle(), rental2.late_fees());

		Comedy comedy = new Comedy(1, "PG", "Funny Movie");
		Rental rental3 = new Rental(comedy, 4, 2);
		System.out.printf("the late fee for %s is $%f%n", comedy.getTitle(), rental3.late_fees());
		
		Drama drama = new Drama(1, "PG", "Serious Movie");
		Rental rental4 = new Rental(drama, 4, 2);
		System.out.printf("the late fee for %s is $%f%n", drama.getTitle(), rental4.late_fees());
		
		Rental[] rental_array = new Rental[4];
		rental_array[0] = rental1;
		rental_array[1] = rental2;
		rental_array[2] = rental3;
		rental_array[3] = rental4;
		
		//method to calc total late fees
		rental4.lateFeesOwed(rental_array);
		
	}
	
	private int days_late, customer_id;
	private Movie movie;
	
	Rental(Movie movie, int days_late, int customer_id)
	{
		this.movie = movie;
		this.days_late = days_late;
		this.customer_id = customer_id;
	}
	
	public double late_fees()
	{
		return movie.calcLateFees(days_late);
	}
	
	public double lateFeesOwed(Rental[] rentals)
	{
		double total_cost = 0;
		for(int i = 0; i < rentals.length; i++)
		{
			total_cost += rentals[i].late_fees();			
		}
		System.out.printf("the total cost of all rentals is $%f%n", total_cost);
		return total_cost;

	}
}