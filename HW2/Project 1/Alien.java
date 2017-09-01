/* Chapter No. 8 Exercise No. 1
   File Name: Alien.java
   Programmer: Sean Malter
   Date Last Modified: September 1, 2017

   Problem Statement: I want to implement an abstract class that has the method
   getDamage() as an abstract

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

public abstract class Alien {

	public static final int DEFAULT_DAMAGE = 0;
	private int health; // 0=dead, 100=full strength
	private String name;

   	/**
	* Default constructor;  Initialize name and health.
 	*/
	public Alien()
	{
		health = 100;
		name = "";
	}

  	 /**
	* Default constructor;  Initialize variables to input parameters.
	* @param health Initial health
	* @param name   Initial name
 	*/
	public Alien(int health, String name)
	{
		this.health = health;
		this.name = name;
	}

// ======================
// Various accessor and mutator methods
// ======================
    public int getHealth()
    {
        return health;
    }

    public void setHealth(int health)
    {
        this.health = health;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String toString()
    {
    	return (name + " " + health);
    }

	/**
	* getDamage returns the amount of damage this alien inflicts.
	*/
    	public abstract int getDamage();

}
