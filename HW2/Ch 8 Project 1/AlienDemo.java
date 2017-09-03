class AlienDemo
{
	// ======================
	//    main method.
	//    In main we simply create a small pack and output its total damage (33).
	// ======================
	public static void main(String[] args)
	{
		OgreAlien brutus = new OgreAlien(100,"brutus");
		SnakeAlien slimy = new SnakeAlien(100,"slimy");
		MarshmallowAlien puffy = new MarshmallowAlien(100,"puffy");
		OgreAlien grumpy = new OgreAlien(100,"grumpy");
		SnakeAlien asteroid = new SnakeAlien(100,"asterpod");

		int packSize = 5;

		AlienPack pack = new AlienPack(packSize);	// 5 aliens in the pack
		pack.addAlien(brutus, 0);
		pack.addAlien(slimy, 1);
		pack.addAlien(puffy, 2);
		pack.addAlien(grumpy, 3);
		pack.addAlien(asteroid, 4);


		System.out.println("The pack consists of " + packSize + " members");
		System.out.println("with their health values:");
		System.out.println("");

		System.out.println(brutus);
		System.out.println(slimy);
		System.out.println(puffy);
		System.out.println(grumpy);
		System.out.println(asteroid);

		System.out.println("");
		System.out.println("Total pack damage = " + pack.calculateDamage());

		//test abstract class & methods
		Alien alien = new OgreAlien();
		System.out.println(alien.getDamage());
		Alien alien2 = new SnakeAlien();
		System.out.println(alien2.getDamage());

	}
}
