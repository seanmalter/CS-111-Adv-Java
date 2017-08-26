/**
 * @(#)Flower.java
 *
 * Sample Applet application
 *
 * @author 
 * @version 1.00 17/08/24
 */
 
import java.awt.*;
import java.applet.*;
import javax.swing.JApplet;
import java.awt.Graphics;


public class Flower extends Applet {
	
	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillOval(150, 150, 50, 50);
		g.setColor(Color.YELLOW);
		g.fillOval(150, 50, 50, 100);
		g.fillOval(150, 200, 50, 100);
		g.fillOval(50, 150, 100, 50);
		g.fillOval(200, 150, 100, 50);
	}
}