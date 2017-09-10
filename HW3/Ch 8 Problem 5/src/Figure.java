 /* Chapter No. 8 - Exercise No. 5
 File Name: Figure.java
 Programmer: Sean Malter
 Date Last Modified: September 10, 2017

 Problem Statement: (what you want the code to do)
 Write classes Figure, Rectangle and Triangle and methods to erase and draw
 
 
 Overall Plan (Algorithm - step-by-step plan to make it happen):
 1. add the reused pieces of code to the Figure Class
 2. Add unique methods to the Rectangle and Triangle classes
 3. Add main to test the methods in the figure class

 Classes needed and Purpose (Input, Processing, Output)
 main class - Figure
 --- Rectangle
 --- Triangle
 

*/

 
public abstract class Figure {
	 
	 public static void main(String[] args) {
		 Rectangle rect = new Rectangle(3,3);
		 rect.center();
		 
		 Triangle tri = new Triangle(3);
		 tri.center();
	 }
	 
	 private String[][] drawing = new String[10][10];
	 
	 Figure()
	 {
		 for(int i = 0; i < 10; i++)
		 {
			 for(int j = 0; j < 10; j++)
			 {
				 drawing[i][j] = "-";
			 }
		 }
	 }
	 
	 public String[][] getDrawing()
	 {
		 return drawing;
	 }
	 
	 public void setDrawing(String[][] newDrawing)
	 {
		 drawing = newDrawing;
	 }
	 
	 public String toString()
	 {
		String printline = "";
		 for(String[] line : drawing)
		 {
			 for(String cell : line)
			 {
				 printline += cell;
			 }
			 printline+= "\n";
		 }
		 return printline;
	 }
	 
	 public abstract void erase();
	 
	 public abstract void draw();
	 
	 public abstract void center();
}
