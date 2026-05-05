
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class MouseClick extends JFrame {

    JLabel coordinatesLabel;
    JLabel clickCountLabel;
    int clickCount = 0;

    MouseClick() {
        setTitle("Mouse Click Tracker");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        coordinatesLabel = new JLabel("Click anywhere in this windows");
        clickCountLabel = new JLabel("Total clicks: 0");
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(coordinatesLabel, BorderLayout.CENTER);
        panel.add(clickCountLabel, BorderLayout.SOUTH);
        panel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                clickCount++;
                coordinatesLabel.setText("Clicked at: (" + x + "," + y + ")");
                clickCountLabel.setText("Total Clicks: " + clickCount);

            }

        });
        add(panel);
        setVisible(true);

    }

    public static void main(String[] args) {
        MouseClick tracker = new MouseClick();
    }
}
