
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

class FirstEvents extends JFrame {
    JTextField tf;
    FirstEvents() {
        tf = new JTextField();
        tf.setBounds(60,50,170,20);
        setLayout(null);
        JButton jb = new JButton("Click me.");
        jb.setBounds(100,120,80,30);
        jb.addActionListener(new Handler());
        add(tf);
        add(jb);
        setSize(300,300);
        setVisible(true);
    }
    public static void main(String[] args) {
        new FirstEvents();
    }

    class Handler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            tf.setText("Welcome");
        }
    }
}