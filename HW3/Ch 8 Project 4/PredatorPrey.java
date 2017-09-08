/* Chapter No. 8 - Exercise No. 4
   File Name: predator-prey-driver
   Programmer: Sean Malter
   Date Last Modified: Septermber 6, 2017

   Problem Statement: I want the code to model the predator prey simulation
   and when the user presses enter, another step happens.

   Overall Plan (Algorithm - step-by-step plan to make it happen):
   1. set up the oganism class to handle the method set up and constructors
   2. set up the ant class
   3. set up the doodle class
   4. create the main method to create the ASCII graph and display locations
   5. initialize the ant's and doodle bugs

   Classes needed and Purpose (Input, Processing, Output)
   Oganism - parent and holds common functions
   Ant - specific functions to the ant
   Map - accessors and mutators for the Map
   Doodle - specific functions for the doodle bug
*/

import java.util.Random;

class PredatorPrey
{
  public static void main(String[] args)
  {
    Organism bug1 = new Organism(1,1);
    //Organism bug2 = new Organism(6,6);


    //map = bug1.breed(map);

    BugMap map1 = new BugMap();
    map1.getNeighbors(1,0).values().forEach(space -> System.out.println(space));
    map1.printMap();

    //System.out.println(map1.getSpace(1,1));
    //System.out.println(map1.getSpace(0,1));
  }
}
