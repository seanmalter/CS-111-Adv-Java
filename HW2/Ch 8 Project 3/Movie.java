public class Movie
{
  private int id;
  private String rating, title;
  private double LATE_FEE_RATE = 2;
  
  Movie()
  {
  	this.id = 1;
  	this.rating = "PG";
  	this.title = "Movie Name";
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