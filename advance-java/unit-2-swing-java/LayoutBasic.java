
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class LayoutBasic extends JFrame {
    LayoutBasic() {
        setSize(500,500);
        setTitle("JFrame.");
    
        // for no layout
        // setLayout(null);

        // for flow layout
        // setLayout(new FlowLayout());

        // for grid layout
        // setLayout(new GridLayout(2,2));

        // for gridbag layout
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        JLabel label1 = new JLabel("Label 1");
        // label1.setBounds(10,10,100,20);
        add(label1);
        // then in adding objects, we need to give gbc.
        

        JButton button1 = new JButton("Button 1");
        // button1.setBounds(200,10,100,20);
        add(button1);

        JLabel label2 = new JLabel("Label 2");
        // label2.setBounds(150,40,100,20);
        add(label2);

        JButton button2 = new JButton("Button 2");
        // button2.setBounds(300,40,100,20);
        add(button2);

        setVisible(true);

    }
    public static void main(String[] args) {
        new LayoutBasic();
    }
}