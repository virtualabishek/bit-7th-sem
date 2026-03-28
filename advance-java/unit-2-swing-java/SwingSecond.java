import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// JFrame

public class SwingSecond extends JFrame {
    SwingSecond() {
        setSize(500,500);
        setTitle("JFrame Demo");
        setLayout(new GridLayout(5,5));
        JLabel myJLabel = new JLabel("JLabel..");
        add(myJLabel);
        JButton myButton = new JButton("Submit");
        myButton.setBounds(150, 100, 50, 20);
        add(myButton);
        JTextField myTextField = new JTextField("Defaut Value");
        add(myTextField);
        setVisible(true);
        JTextArea myTextArea = new JTextArea("JTextArea");
        JScrollPane myScrollPane = new JScrollPane(myTextArea);
        add(myScrollPane);
        JCheckBox myCheckBox = new JCheckBox("JCheckBox");
        add(myCheckBox);
    } 

    public static void main(String[] args) {
        new SwingSecond();

    }
}