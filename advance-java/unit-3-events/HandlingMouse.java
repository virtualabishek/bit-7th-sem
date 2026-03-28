import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HandlingMouse extends JFrame implements MouseListener {
  int x, y, r1, r2;
  HandlingMouse() {
    addMouseListener(this);
    setTitle("Mouse Events");
    setSize(500, 500);
    setVisible(true);
  }


  public void mouseClicked(MouseEvent me) {
    x = me.getX();
    y = me.getY();
    r1= 60;
    r2 = 40;
    repaint();
  }

  public void mouseExited(MouseEvent me) {}
  public void mouseEntered(MouseEvent me) {}
  public void mousePressed(MouseEvent me) {}
  public void mouseReleased(MouseEvent me) {}

  public void paint(Graphics g) {
    g.drawOval(x,y,r1,r2);
  }

  public static void main(String[] args) {
    new HandlingMouse();
    
  }
}
