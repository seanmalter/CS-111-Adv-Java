/**
 * @(#)DrawRect.java
 *
 * Draw a circle inside a square
 *
 * @author 
 * Sean Malter
 * @version 1.00 17/08/23
 */
 
import java.awt.*;
import java.applet.*;
import javax.swing.JApplet;
import java.awt.Graphics;

public class DrawRect extends JApplet {
	
	public static final int X_SQUARE = 50;
	public static final int Y_SQUARE = 50;
	public static final int SQUARE_SIZE = 100;
	
	public void paint(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(X_SQUARE, Y_SQUARE, SQUARE_SIZE, SQUARE_SIZE);
		g.setColor(Color.BLUE);
		g.fillOval(X_SQUARE, Y_SQUARE, SQUARE_SIZE, SQUARE_SIZE);
	}
}
