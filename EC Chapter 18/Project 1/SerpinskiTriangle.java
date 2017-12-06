import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import javax.swing.JFrame;

public class SerpinskiTriangle extends Canvas {

  public void paint(Graphics g)
  {

        //set up x, y, z location
        int X_x;
        int X_y;
        int Y_x;
        int Y_y;
        int Z_x;
        int Z_y;

        X_x = 0;
        X_y = 0;
        Y_x = 500;
        Y_y = 0;
        Z_x = 250;
        Z_y = 500;

        int currentX = X_x;
        int currentY = X_y;
        int targetX, targetY;
        int midwayX, midwayY;
        Random r = new Random();

        for(int i = 0; i < 10000; i++)
        {
          int random = r.nextInt(3);
          if(random == 0)
          {
            targetX = X_x;
            targetY = X_y;
          }
          else if(random == 1)
          {
            targetX = Y_x;
            targetY = Y_y;
          }
          else
          {
            targetX = Z_x;
            targetY = Z_y;
          }

          //halfway between
          currentX = (targetX + currentX) / 2;
          currentY = (targetY + currentY) / 2;
          g.drawLine(currentX, currentY, currentX, currentY);
        }
  }

	public static void main(String s[]) {

    SerpinskiTriangle m=new SerpinskiTriangle();
       JFrame f=new JFrame();
       f.add(m);
       f.setSize(500,500);
       //f.setLayout(null);
       f.setVisible(true);

	}
}
