
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class StudentForm extends JFrame implements ActionListener {

    JTextField nameField, emailField;
    JPasswordField passwordField;
    JRadioButton male, female;
    JComboBox<String> courseBox;
    JButton sumbitBtn;

    StudentForm() {
        setLayout(new GridLayout(7, 2, 5, 5));
        add(new JLabel("Name: "));
        nameField = new JTextField();
        add(nameField);
        add(new JLabel("Email: "));
        emailField = new JTextField();
        add(emailField);
        add(new JLabel("Password"));
        passwordField = new JPasswordField();
        add(passwordField);
        add(new JLabel("Gender: "));
        JPanel genderPanel = new JPanel();
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);
        genderPanel.add(male);
        genderPanel.add(female);
        add(genderPanel);
        add(new JLabel("Courses"));
        String[] courses = {"Select", "BIT", "Bsc.CSIT", "BBA"};
        courseBox = new JComboBox<>(courses);
        add(courseBox);
        sumbitBtn = new JButton("Submit");
        sumbitBtn.addActionListener(this);
        add(sumbitBtn);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String name = nameField.getText();
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        String gender = "";
        String course = (String) courseBox.getSelectedItem();
        if (male.isSelected()) {
            gender = "Male"; 
        }else if (female.isSelected()) {
            gender = "Female";
        }
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Name cannot empty.");
        } else if (!email.contains("@")) {
            JOptionPane.showMessageDialog(this, "Invalid email.");
        } else if (password.length() < 0) {
            JOptionPane.showMessageDialog(this, "Password must be longer than 6 chars.");
        } else if (course.equals("")) {
            JOptionPane.showMessageDialog(this, "Select Gender");
        } else if (course.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Select Course");
        } else {
            JOptionPane.showMessageDialog(this, "Registration Successful!");
        }
    }

    public static void main(String[] agrs) {
        new StudentForm();
    }
}
