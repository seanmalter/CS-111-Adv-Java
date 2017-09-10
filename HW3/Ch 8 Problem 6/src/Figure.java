 /* Chapter No. 8 - Exercise No. 6
 File Name: Figure.java
 Programmer: Sean Malter
 Date Last Modified: September 10, 2017

 Problem Statement: (what you want the code to do)
 Write classes Figure, Rectangle and Triangle and methods to erase and draw
 triangles & rectangles in ASCII

 
 Overall Plan (Algorithm - step-by-step plan to make it happen):
 1. build ontop of problem 5
 2. add print method on Figure
 3. add draw, erase, center methods on Rectangle and Triangle
 add accessors, mutators to the child classes
 algorithm to print the two shapes added to parent class
 method to center the figures on the page

 Classes needed and Purpose (Input, Processing, Output)
 main class - Figure
 --- Rectangle
 --- Triangle
 

*/

 
public abstract class Figure {
	 
	 public static void main(String[] args) {
		 Rectangle rect = new Rectangle(2,5);
		 rect.draw(0,0);
		 System.out.println(rect);
		 rect.center();
		 System.out.println(rect);
		 
		 Triangle tri = new Triangle(5);
		 tri.draw(0,  0);
		 System.out.println(tri);
		 tri.center();
		 System.out.println(tri);
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
	 
	 public String[][] resetDrawing()
	 {
		 for(int i = 0; i < 10; i++)
		 {
			 for(int j = 0; j < 10; j++)
			 {
				 drawing[i][j] = "-";
			 }
		 }
		 return drawing;
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
	 
	 public abstract void draw(int offsetX, int offsetY);
	 
	 public abstract void center();
}
