import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class BorderCon extends JFrame {
    BorderCon() {
        setSize(500,500);
        setTitle("JFrame.");
    
        // for no layout
        // setLayout(null);

        // for flow layout
        // setLayout(new FlowLayout());

        // for grid layout
        // setLayout(new GridLayout(2,2));

        // for gridbag layout
        // setLayout(new GridBagLayout());

        // BorderConstraints gbc = new BorderConstraints();
        // for Border Layout
        setLayout(new BorderLayout());

        JLabel label1 = new JLabel("Label 1");
        // label1.setBounds(10,10,100,20);
        // add(label1);
        // then in adding objects, we need to give gbc.
        add(label1, BorderLayout.NORTH)
        

        JButton button1 = new JButton("Button 1");
        // button1.setBounds(200,10,100,20);
        
        add(button1, BorderLayout.WEST);

        JLabel label2 = new JLabel("Label 2");
        // label2.setBounds(150,40,100,20);
        add(label2, BorderLayout.WEST);

        JButton button2 = new JButton("Button 2");
        // button2.setBounds(300,40,100,20);
        add(button2, BorderLayout.CENTER);

        setVisible(true);

    }
    public static void main(String[] args) {
        new BorderCon();
    }
}