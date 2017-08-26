/**
 * @(#)CresantMoon.java
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

public class CresantMoon extends Applet {
	
	public static final int X_START = 15;
	public static final int Y_START = 15;
	public static final int WIDTH = 150;
	public static final int HEIGTH = 150;
	public static final int ANGLE_START = 90;
	public static final int ANGLE_LENGTH = 180;
	
	public void paint(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillArc(X_START, Y_START, WIDTH, HEIGTH, ANGLE_START, ANGLE_LENGTH);
		g.setColor(Color.WHITE);
		g.fillArc(X_START + 10, Y_START, WIDTH - 10, HEIGTH, ANGLE_START, ANGLE_LENGTH);
	}
}
