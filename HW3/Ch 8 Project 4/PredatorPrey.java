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

import java.util.Scanner;

class PredatorPrey
{
  public static void main(String[] args)
  {
  	Doodlebug bug1 = new Doodlebug(1,1);
    BugMap map1 = new BugMap();
    int x = 0;
    while(x == 0)
    {
      map1.start();
      System.out.println("press enter to continue");
      new Scanner(System.in).nextLine();
    }
  }
}
