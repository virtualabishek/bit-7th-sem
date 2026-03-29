import javax.swing.*;
import java.awt.*;

public class GridJa {
    public static void main(String[] args) {
        JFrame frame = new JFrame("GridLayout Example");
        
        // Set GridLayout with 2 rows and 3 columns
        frame.setLayout(new GridLayout(2, 3, 5, 5));

        // Add buttons
        for (int i = 1; i <= 6; i++) {
            frame.add(new JButton("Button " + i));
        }

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
