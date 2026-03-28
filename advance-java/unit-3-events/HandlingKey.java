import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HandlingKey extends JFrame implements KeyListener {
  private JTextField t1, t2, t3;
  JLabel l1, l2, l3;
  JButton b;
  HandlingKey() {
    l1 = new JLabel("First Number: ");
    l2 = new JLabel("Second Number: ");
    l3 = new JLabel("Result: ");
    t1 = new JTextField(10);
    t2 = new JTextField(10);
    t3 = new JTextField(10);
    b = new JButton("Calculate");
    b.addKeyListener(this);
    add(l1);
    add(t1);
    add(l2);
    add(t2);
    add(l3);
    add(t3);
    add(b);
    setLayout(new FlowLayout(FlowLayout.LEFT, 150, 10));
    setTitle("Calculate");
    setSize(500, 500);
    setVisible(true);
  }
  public void keyPressed(KeyEvent e) {
    int x, y, z;
    x = Integer.parseInt(t1.getText());
    y = Integer.parseInt(t2.getText());
    if(e.getKeyChar() == 's') {
      z = x - y;
    } else if(e.getKeyChar() == 'a') {
      z = x + y;
    } else {
      t3.setText("Press a or s.");
      return;
    }
    t3.setText(String.valueOf(z));
  }

  public void keyReleased(KeyEvent e) {}
  public void keyTyped(KeyEvent e) {}

  public static void main(String[] args) {
    new HandlingKey();
  }

}
