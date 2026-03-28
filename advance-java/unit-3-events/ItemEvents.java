import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ItemEvents extends JFrame implements ItemListener {
  JRadioButton rb1, rb2;
  JLabel l1, l2;
  ButtonGroup bg;
  JComboBox cb;
  ItemEvents() {
    setTitle("This is Item Listener");
    setLayout(new FlowLayout(FlowLayout.CENTER, 100, 50));
    l1 = new JLabel("Gender");
    rb1 = new JRadioButton("Male");
    rb2 = new JRadioButton("Female");
    bg = new ButtonGroup();
    l2 = new JLabel("Country");
    String[] cn = {"Nepal", "Russia",  "China", "Germany", "Spain", "France"};
    cb = new JComboBox(cn);
    add(l1);
    bg.add(rb1);
    bg.add(rb2);
    add(l2);
    add(rb1);
    add(rb2);
    add(cb);
    rb1.addItemListener(this);
    rb2.addItemListener(this);
    cb.addItemListener(this);
    setSize(500,500);
    setVisible(true);
  }

  public void itemStateChanged(ItemEvent ie) {
    if(ie.getSource()==rb1 && rb1.isSelected()==true) {
      JOptionPane.showMessageDialog(this, "You are male");
    } else if(ie.getSource()==rb2 && rb2.isSelected()==true) {
      JOptionPane.showMessageDialog(this, "You are female.");
    } else if(ie.getSource()==cb && ie.getStateChange()==ie.SELECTED) {
      JOptionPane.showMessageDialog(this, "Your country is: " + cb.getSelectedItem());
    }
  }

  public static void main(String[] args) {
    new ItemEvents();
  }
}
