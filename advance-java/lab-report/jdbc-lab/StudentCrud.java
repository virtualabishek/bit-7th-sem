
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentCrud {

    static final String URL = System.getenv().getOrDefault("DB_URL", "jdbc:mysql://localhost:3306/student_java");
    static final String USER = System.getenv("DB_USER");
    static final String PWD = System.getenv("DB_PASSWORD");

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        try (Connection conn = DriverManager.getConnection(URL, USER, PWD)) {
            System.out.println("Connected to Database");
            while (true) {
                System.out.println("Guides for you. Press num.");
                System.out.println("1. Insert Students");
                System.out.println("2. Update Students");
                System.out.println("3. Delete Students");
                System.out.println("4. Show Students");
                System.out.println("5. Exit");
                System.out.println("Insert your choice: ");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1 ->
                        insertStudent(conn, sc);
                    case 2 ->
                        updateStudent(conn, sc);
                    case 3 ->
                        deleteStudent(conn, sc);
                    case 4 ->
                        showStudent(conn);
                    case 5 -> {
                        System.out.println("Exiting...");
                        return;
                    }
                    default ->
                        System.out.println("Invalid Choice!");
                }
            }
        }
    }

    static void insertStudent(Connection conn, Scanner sc) throws SQLException {
        sc.nextLine();
        System.out.println("Name: ");
        String name = sc.nextLine();
        System.out.println("Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println("Course: ");
        String course = sc.nextLine();
        System.out.println("Marks: ");
        double marks = sc.nextDouble();
        String sql = "INSERT INTO students (name, age, course, marks) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, course);
            ps.setDouble(4, marks);
            int rows = ps.executeUpdate();
            System.out.println(rows + "Updated.");
        }
    }

    static void updateStudent(Connection conn, Scanner sc) throws SQLException {
        System.out.println("Enter student id to update data: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("enter course and marks");
        System.out.println("Enter Coourse: ");
        String course = sc.nextLine();
        System.out.println("Enter marks: ");
        double marks = sc.nextDouble();
        String sql = ("UPDATE students SET course = ?, marks = ?  WHERE id = ?");
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, course);
            ps.setDouble(2, marks);
            ps.setInt(3, id);
            ps.executeUpdate();
            System.out.println("Updated successfully!");
        }
    }

    static void deleteStudent(Connection conn, Scanner sc) throws SQLException {
        System.out.println("Enter student ID to delete");
        int id = sc.nextInt();
        String sql = "DELETE FROM students WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Student deleted with " + id + "successfully");
        }
    }

    static void showStudent(Connection conn) throws SQLException {
        String sql = "SELECT * FROM students";
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            System.out.println("ID   ,    Name    ,   Age ,     Course , Marks   ");
            while (rs.next()) {
                System.out.printf("%d, %s, %d, %s, %.2f%n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("course"),
                        rs.getDouble("marks"));
            }
        }
    }

}
