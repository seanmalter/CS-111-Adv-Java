/**
 * @(#)Person.java
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

public class Person extends Applet {
	
	public static final int HEAD_SIZE = 20;
	public static final int EYE_SIZE = 5;
	public static final int BODY_HEIGHT = 40;
	public static final int BODY_WIDTH = 30;
	
	public void paint(Graphics g) {
		
		int i, xOffset;
		for(i = 0; i < 3; i++){
			xOffset = 50 + i * 70;
			
			switch(i){
				case 0:
					g.setColor(Color.YELLOW);
					g.fillOval(xOffset, 50, HEAD_SIZE, HEAD_SIZE);
					g.setColor(Color.BLACK);
					g.drawArc( xOffset + 8, 55, 10,10, 180, 180);
					g.fillOval(xOffset + 8, 55, EYE_SIZE, EYE_SIZE);
					g.fillOval(xOffset + 12, 55, EYE_SIZE, EYE_SIZE);
					break;
				case 1:
					g.setColor(Color.RED);
					g.fillOval(xOffset, 50, HEAD_SIZE, HEAD_SIZE);
					g.setColor(Color.BLACK);
					g.drawArc( xOffset + 10, 60, 10,10, 0, 180);
					g.fillOval(xOffset + 8, 55, EYE_SIZE, EYE_SIZE);
					g.fillOval(xOffset + 12, 55, EYE_SIZE, EYE_SIZE);
					break;
				case 2:
					g.setColor(Color.GREEN);
					g.fillOval(xOffset, 50, HEAD_SIZE, HEAD_SIZE);
					g.setColor(Color.BLACK);
					g.fillOval( xOffset + 8, 60, 10,10);
					g.fillOval(xOffset + 8, 55, EYE_SIZE, EYE_SIZE);
					g.fillOval(xOffset + 12, 55, EYE_SIZE, EYE_SIZE);
					break;
			}			
	
			g.drawOval(xOffset - 5, 70, BODY_WIDTH, BODY_HEIGHT);
			g.drawOval(xOffset - 5, 70, BODY_WIDTH, BODY_HEIGHT);
			
			
			//draw arms
	    	g.drawOval(xOffset, 85, 40, 10);
	    	g.drawOval(xOffset + 10, 75, 40, 10);
	    	
	    	//draw legs
	    	g.drawOval(xOffset, 100, 11, 50);
	    	g.drawOval(xOffset + 10, 100, 50, 11);
		}
	}
}
