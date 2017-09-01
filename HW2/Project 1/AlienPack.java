// This class stores an array of Aliens that comprise a "pack"

class AlienPack
{
	private Alien[] aliens;

	public AlienPack(int numAliens)
	{
		aliens = new Alien[numAliens];
	}

	public void addAlien(Alien newAlien, int index)
	{
		aliens[index] = newAlien;
	}

	public Alien[] getAliens()
	{
		return aliens;
	}
	

  	/**
	* To calculate the damage inflicted by all aliens in the pack
	* we can now simply iterate through each alien and call its
	* getDamage() method
 	*/
	public int calculateDamage()
	{
		int damage = 0;
		for (int i=0; i < aliens.length; i++)
		{
			damage += aliens[i].getDamage();
		}
		return damage;
	}
} 
