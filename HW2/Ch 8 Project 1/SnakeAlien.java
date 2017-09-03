


class SnakeAlien extends Alien
{
	public static final int SNAKE_DAMAGE  = 10;

  	 /**
	* Constructors
 	*/
	public SnakeAlien()
	{
		super();
	}

	public SnakeAlien(int health, String name)
	{
		super(health,name);
	}

	/**
	* getDamage returns the amount of damage this alien inflicts.
	*/
	public int getDamage()
	{
		return SNAKE_DAMAGE;
	}
}
