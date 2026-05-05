import java.awt.Color;
import javax.swing.*;
class ColorChooser extends JFrame {
    JColorChooser cc;
    JPanel p;
    JDialog d;
    ColorChooser() {
        setSize(700,500);
        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Parent Frame.");
        cc = new JColorChooser();
        Color c = cc.showDialog(this, "Select new color....", Color.WHITE);
        p.setBackground(c);

    }
    public static void main(String[] args) {
        ColorChooser c = new ColorChooser();
    }
    
}