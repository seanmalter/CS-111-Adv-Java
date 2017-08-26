/**
 * @(#)LoopDrawing.java
 *
 * Sample Applet application
 *
 * @author 
 * @version 1.00 17/08/25
 */
 
import java.awt.*;
import java.applet.*;
import javax.swing.JApplet;
import java.awt.Graphics;

public class LoopDrawing extends Applet {
	

	public void paint(Graphics g) {
		int i = 0;
		while(i < 50){
			if((i & 1) == 0){
				g.setColor(Color.BLUE);	
			}
			else if((i & 2) == 2){
				g.setColor(Color.GREEN);	
			}
			else if((i & 4) == 4){
				g.setColor(Color.YELLOW);
			}
			g.fillOval(i*20 % 300, i *66 % 300, i * 5, i*3%40);
			i++;
		}	
	}
}
