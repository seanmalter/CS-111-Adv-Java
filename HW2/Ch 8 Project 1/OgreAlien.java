/**
 * Class for the Ogre Alien
 */
class OgreAlien extends Alien
{
	public static final int OGRE_DAMAGE  = 6;
   	/**
	* Constructors
 	*/
	public OgreAlien()
	{
		super();
	}
	public OgreAlien(int health, String name)
	{
		super(health,name);
	}

	/**
	* getDamage returns the amount of damage this alien inflicts.
	*/
	public int getDamage()
	{
		return OGRE_DAMAGE;
	}
} 
