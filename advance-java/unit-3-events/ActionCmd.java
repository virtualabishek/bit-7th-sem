import javax.swing.JFrame;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
class ActionCmd extends JFrame implements ActionListener {
  JLabel lb;
  ActionCmd() {
    lb = new JLabel();
    lb.setBounds(60,50,170,20);
    setLayout(null);
    JButton b1 = new JButton("Continue");
    b1.setBounds(50, 120, 80, 30);
    JButton b2 = new JButton("Ok");
    b2.setBounds(140, 120, 80, 30);
    add(lb);
    add(b1);
    add(b2);
    b1.addActionListener(this);
    b2.addActionListener(this);
    b1.setActionCommand("proceed");
    b2.setActionCommand("proceed");
    setSize(500,500);
    setVisible(true);
  }

    public void actionPerformed(ActionEvent e) {
      if(e.getActionCommand()=="proceed") {
        lb.setText("Do you want to proceed???");
      }
    }
  public static void main(String[] args) {
    new ActionCmd();
  }

}
