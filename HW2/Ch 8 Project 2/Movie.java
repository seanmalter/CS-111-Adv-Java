/* Chapter No. 8 Exercise No. 2
   File Name: Movie.java
   Programmer: Sean Malter
   Date Last Modified: September 1, 2017

   Problem Statement: I want to implement a Movie class to store movie information
   and

   Overall Plan (Algorithm - step-by-step plan to make it happen):
   1. Build the Movie class
   2. Create accessor and mutator methods
   3. Equals method to check if an objects id is same as this classes id
   4. create 3 child classes (drama, action, comedy)
   5. add calculate late fees to the 3 child classes
   6. test classes from main method

   Classes needed and Purpose (Input, Processing, Output)
   Movie
   Action
   Drama
   Comedy
*/

public class Movie
{
  private int id;
  private String rating, title;
  private double LATE_FEE_RATE = 2;


    public static void main(String[] args)
  {
	Movie movie = new Movie(1,"PG", "Lion King");
	movie.setRating("R");
	System.out.printf("the rating for Lion King is %s %n", movie.getRating());
	Movie movie2 = new Movie(1, "PG", "Not Lion King");
	System.out.printf("Boolean for if the two movies have the same id: %b %n", movie.equals(movie2));

	//test Action class late fees
	Action action = new Action(1, "PG", "Not Lion King");
	System.out.printf("the action movie is called %s %n", action.getTitle());
	System.out.printf("the late fee is $ %f %n", action.calcLateFees(5));

	//test Comedy class
	Comedy comedy = new Comedy(1, "PG", "Funny Movie");
	System.out.printf("the comedy movie is called %s %n", comedy.getTitle());
	System.out.printf("the late fee is $ %f %n", comedy.calcLateFees(5));

	//test Drama class
	Drama drama = new Drama(1, "PG", "Serious Movie");
	System.out.printf("the Drama movie is called %s %n", drama.getTitle());
	System.out.printf("the late fee is $ %f %n", drama.calcLateFees(5));
  }

  Movie(int id, String rating, String title)
  {
    this.id = id;
    this.rating = rating;
    this.title = title;
  }

  public int getId()
  {
  	return this.id;
  }

  public String getRating()
  {
  	return this.rating;
  }

  public String getTitle()
  {
  	return this.title;
  }

  public void setId(int newId)
  {
  	this.id = newId;
  }

  public void setRating(String newRating)
  {
  	this.rating = newRating;
  }

  public void setTitle(String newTitle)
  {
  	this.title = newTitle;
  }

  //overriding equals() to compare id's of two Moives
  @Override
  public boolean equals(Object o)
  {
  	if(o instanceof Movie)
  	{
  		Movie other = (Movie) o;
  		return this.id == other.getId();
  	}
  	return false;
  }

  //default late fees for movies ($2 / day)
  public double calcLateFees(int days)
  {
  	return days * LATE_FEE_RATE;
  }
}
