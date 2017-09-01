/**
* Class for the Marshmallow Alien
*/
class MarshmallowAlien extends Alien
{
	public static final int MARSHMALLOW_DAMAGE  = 1;
   	/**
	* Constructors
 	*/
	public MarshmallowAlien()
	{
		super();
	}

	public MarshmallowAlien(int health, String name)
	{
		super(health,name);
	}

	/**
	* getDamage returns the amount of damage this alien inflicts.
	*/
	public int getDamage()
	{
		return MARSHMALLOW_DAMAGE;
	}
} // 