import javax.swing.*;
public  class SwingFirst {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        JButton b = new JButton();
        b.setBounds(130,100,50,20);
        f.add(b);
        f.setSize(400,500);
        f.setLayout(null);
        f.setVisible(true);
    }
}