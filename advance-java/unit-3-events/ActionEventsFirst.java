import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ActionEventsFirst extends JFrame implements ActionListener {
  private JTextField t1, t2, t3;
  JLabel l1, l2, l3;
  JButton b1, b2;
  ActionEventsFirst() {
    super("Handling Action Event");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    l1 = new JLabel("First Value: ");
    l2 = new JLabel("Second Value: ");
    l3 = new JLabel("Result");
    t1 = new JTextField(10);
    t2 = new JTextField(20);
    t3 = new JTextField(30);
    b1 = new JButton("Add");
    b2 = new JButton("Subtract");
    b1.addActionListener(this);
    b2.addActionListener(this);
    setLayout(new FlowLayout(FlowLayout.LEFT, 150, 10));
    add(l1);
    add(t1);
    add(l2);
    add(t2);
    add(l3);
    add(t3);
    add(b1);
    add(b2);
    setSize(500, 500);
    setTitle("Handling Action Events");
    setVisible(true);
  }

  public void actionPerformed (ActionEvent e) {
    int x, y, z;
    x = Integer.parseInt(t1.getText());
    y = Integer.parseInt(t2.getText());
    if(e.getActionCommand() == "Add") {
      z = x + y;
    } else {
      z = x - y;
    }
    t3.setText(String.valueOf(z));
  } 

  public static void main(String[] args) {
    new ActionEventsFirst();
  }

}
