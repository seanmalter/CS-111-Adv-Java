/* Chapter No. 8 Exercise No. 1
   File Name: Movie.java
   Programmer: Sean Malter
   Date Last Modified: September 1, 2017

   Problem Statement: I want to implement a Movie class to store movie information
   and 

   Overall Plan (Algorithm - step-by-step plan to make it happen):
   1. Make Alien abstract
   2. make getDamage() abstract
   3. test the abstract class by calling getDamage on OgreAlien
   4. test class on SnakeAlien

   Classes needed and Purpose (Input, Processing, Output)
   Alien
	 AlienDemo
   MarshmallowAlien
   OgreAlien
   SnakeAlien
*/

public class Movie{
  private int id;
  private String rating;
  private String title;

  Movie(int id, String rating, String title){
    this.id = id;
    this.rating = rating;
    this.title = title;
  }
  public static void main(String[] args) {

  }

}
