import javax.swing.*;

public class ConvertedSwing extends JFrame {
    
    private JLabel label;
    
    public ConvertedSwing() {
        // Set frame properties
        setTitle("JavaFX Example");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Use BoxLayout for vertical layout (like VBox in JavaFX)
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        
        // Create a Label
        label = new JLabel("Hello, Swing!");
        add(label);
        
        // Create a Button
        JButton button = new JButton("Click Me");
        button.addActionListener(e -> label.setText("Button Clicked!"));
        add(button);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new ConvertedSwing();
    }
}
