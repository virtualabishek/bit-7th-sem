
import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class JTableStudent extends JFrame {

    static final String URL = "jdbc:mysql://localhost:3306/student_java";
    static final String USER = "abi";
    static final String PASS = "imp2083";

    public JTableStudent() throws SQLException {
        setTitle("Student database viewer");
        setSize(700, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        String[] cols = {"Id", "Name", "Age", "Course", "Marks"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS); Statement st = conn.createStatement(); ResultSet rs = st.executeQuery("SELECT * FROM students")) {
            while (rs.next()) {
                Object[] row = {
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getString("course"),
                    rs.getDouble("marks")
                };
                model.addRow(row);
            }
        } catch (SQLException e) {
            System.err.println("DB Error: " + e.getMessage());
        }
        JTable table = new JTable(model);
        table.setRowHeight(25);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        JLabel title = new JLabel("Student Records");
        add(title, BorderLayout.NORTH);
        add(table, BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                JTableStudent frame = new JTableStudent();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "DB Error: " + e.getMessage());
            }
        });
    }
}
