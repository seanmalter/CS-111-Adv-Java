/**
 * @(#)Bull's-eye.java
 *
 * Draw a cresant moon
 *
 * @author 
 * Sean Malter
 * @version 1.00 17/08/23
 */
 
import java.awt.*;
import java.applet.*;
import javax.swing.JApplet;
import java.awt.Graphics;

public class BullsEye extends JApplet {
	
	public static final int X_START = 15;
	public static final int Y_START = 15;
	public static final int SIZE = 50;
	
	public void paint(Graphics g) {
		
		int i = 0;
		while(i < 5){
			if(i%2 == 0){
				g.setColor(Color.BLUE);
			}
			else{
				g.setColor(Color.GREEN);
			}
			g.fillOval(X_START + 5*i, Y_START + 5*i, SIZE - 10*i, SIZE - 10*i);
			i++;
		}
	}
}
