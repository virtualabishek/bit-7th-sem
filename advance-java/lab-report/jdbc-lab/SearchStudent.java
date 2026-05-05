
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SearchStudent {

    static final String URL = "jdbc:mysql://localhost:3306/student_java";
    static final String USER = "abi";
    static final String PWD = "imp2083";

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        try (Connection conn = DriverManager.getConnection(URL, USER, PWD)) {
            System.err.println("Student search guides.");
            System.err.println("1. Search by name.");
            System.err.println("2. Search by pass marks");
            System.err.println("Choose search type: ");
            int choice = sc.nextInt();
            String sql;
            PreparedStatement ps;
            switch (choice) {
                case 1 -> {
                    sc.nextLine();
                    System.out.println("Enter name to search: ");
                    String name = sc.nextLine();
                    sql = "SELECT * FROM students WHERE name LIKE ?";
                    ps = conn.prepareStatement(sql);
                    ps.setString(1, "%" + name + "%");
                }
                case 2 -> {
                    System.err.println("Passed students are:  ");
                    double marks = 24;
                    sql = "SELECT * FROM students WHERE marks >= ?";
                    ps = conn.prepareStatement(sql);
                    ps.setDouble(1, marks);
                }
                default -> {
                    System.out.println("Invalid");
                    return;
                }

            }
            boolean found = false;
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    found = true;
                    System.out.printf("%d, %s, %d, %s, %.2f%n",
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("age"),
                            rs.getString("course"),
                            rs.getDouble("marks")
                    );
                }
            }
            if(!found) System.out.println("No records found. be sure there is alrady data. ");
            ps.close();
        }
    }
}
