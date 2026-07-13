
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class LoginForm extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginForm() {
        setTitle("Login Form");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Username: "), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        usernameField = new JTextField(15);
        panel.add(usernameField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        panel.add(new JLabel("Password: "), gbc);
        gbc.gridx=1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        passwordField = new JPasswordField(15);
        panel.add(passwordField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton loginButton = new JButton("Login: ");
        loginButton.addActionListener(e -> validateLogin());
        panel.add(loginButton, gbc);
        add(panel);
    }

    private void validateLogin() {
        String username = usernameField.getText();
        String Password = new String(passwordField.getPassword());
        String validUser = System.getenv("LOGIN_USER");
        String validPass = System.getenv("LOGIN_PASS");
        if (username.equals(validUser) && Password.equals(validPass)) {
            JOptionPane.showMessageDialog(this, "Login Successfull! \n Welcome, " + username);
        } else {
            JOptionPane.showMessageDialog(this, "Invalide Password");
            usernameField.setText("");
            passwordField.setText("");
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()-> {
            LoginForm login = new LoginForm();
            login.setVisible(true);
        });
    }
}
