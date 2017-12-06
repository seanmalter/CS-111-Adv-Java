import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.JFrame;

public class Skeleton  extends Frame implements WindowListener{
  TextField text = new TextField(20);

  public static void main(String[] args) {
          Skeleton myWindow = new Skeleton("My first window");
          myWindow.setSize(350,100);
          myWindow.setVisible(true);
  }

  public Skeleton(String title) {
          super(title);
          setLayout(new FlowLayout());
          addWindowListener(this);
          add(text);
  }
  public void windowOpened(WindowEvent e)
  { text.setText("Window Opened"); }
  public void windowClosing(WindowEvent e)
  { text.setText("Window closing"); }
  public void windowClosed(WindowEvent e)
  { text.setText("Window closed"); }
  public void windowIconified(WindowEvent e)
  { text.setText("Window iconified"); }
  public void windowDeiconified(WindowEvent e)
  { text.setText("Window deiconified"); }
  public void windowActivated(WindowEvent e)
  { text.setText("Window activated"); }
  public void windowDeactivated(WindowEvent e)
  { text.setText("Window deactivated"); }
}
