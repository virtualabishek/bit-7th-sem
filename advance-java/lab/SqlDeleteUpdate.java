import java.sql.*;

public class SqlDeleteUpdate {
    
    private static final String URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String USER = "root";
    private static final String PASSWORD = "your_password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // ========== UPDATE Operations ==========

    public static void updateEmployeeSalary(Connection conn, int id, double newSalary) 
            throws SQLException {
        String sql = "UPDATE employees SET salary = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, newSalary);
            pstmt.setInt(2, id);
            int rows = pstmt.executeUpdate();
            System.out.println(rows + " row(s) updated.");
        }
    }

    public static void updateEmployeeDepartment(Connection conn, int id, String newDepartment) 
            throws SQLException {
        String sql = "UPDATE employees SET department = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newDepartment);
            pstmt.setInt(2, id);
            int rows = pstmt.executeUpdate();
            System.out.println(rows + " row(s) updated.");
        }
    }

    public static void increaseSalaryByPercentage(Connection conn, String department, double percentage) 
            throws SQLException {
        String sql = "UPDATE employees SET salary = salary * (1 + ? / 100) WHERE department = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, percentage);
            pstmt.setString(2, department);
            int rows = pstmt.executeUpdate();
            System.out.println(rows + " row(s) updated in " + department + " department.");
        }
    }

    public static void updateMultipleColumns(Connection conn, int id, String name, double salary, String department) 
            throws SQLException {
        String sql = "UPDATE employees SET name = ?, salary = ?, department = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setDouble(2, salary);
            pstmt.setString(3, department);
            pstmt.setInt(4, id);
            int rows = pstmt.executeUpdate();
            System.out.println(rows + " row(s) updated.");
        }
    }

    // ========== DELETE Operations ==========

    public static void deleteEmployeeById(Connection conn, int id) throws SQLException {
        String sql = "DELETE FROM employees WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int rows = pstmt.executeUpdate();
            System.out.println(rows + " row(s) deleted.");
        }
    }

    public static void deleteEmployeeByEmail(Connection conn, String email) throws SQLException {
        String sql = "DELETE FROM employees WHERE email = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            int rows = pstmt.executeUpdate();
            System.out.println(rows + " row(s) deleted.");
        }
    }

    public static void deleteEmployeesByDepartment(Connection conn, String department) throws SQLException {
        String sql = "DELETE FROM employees WHERE department = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, department);
            int rows = pstmt.executeUpdate();
            System.out.println(rows + " row(s) deleted from " + department + " department.");
        }
    }

    public static void deleteLowSalaryEmployees(Connection conn, double salaryThreshold) throws SQLException {
        String sql = "DELETE FROM employees WHERE salary < ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, salaryThreshold);
            int rows = pstmt.executeUpdate();
            System.out.println(rows + " row(s) deleted with salary below " + salaryThreshold);
        }
    }

    public static void deleteWithMultipleConditions(Connection conn, String department, double salary) 
            throws SQLException {
        String sql = "DELETE FROM employees WHERE department = ? AND salary < ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, department);
            pstmt.setDouble(2, salary);
            int rows = pstmt.executeUpdate();
            System.out.println(rows + " row(s) deleted.");
        }
    }

    // ========== SELECT for Verification ==========

    public static void displayAllEmployees(Connection conn) throws SQLException {
        String sql = "SELECT * FROM employees";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\n--- All Employees ---");
            System.out.printf("%-5s %-15s %-10s %-15s %-25s%n", 
                "ID", "Name", "Salary", "Department", "Email");
            System.out.println("-".repeat(70));
            while (rs.next()) {
                System.out.printf("%-5d %-15s %-10.2f %-15s %-25s%n",
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getDouble("salary"),
                    rs.getString("department"),
                    rs.getString("email"));
            }
        }
    }

    public static void displayEmployeesByDepartment(Connection conn, String department) 
            throws SQLException {
        String sql = "SELECT * FROM employees WHERE department = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, department);
            try (ResultSet rs = pstmt.executeQuery()) {
                System.out.println("\n--- Employees in " + department + " ---");
                System.out.printf("%-5s %-15s %-10s %-15s %-25s%n", 
                    "ID", "Name", "Salary", "Department", "Email");
                System.out.println("-".repeat(70));
                while (rs.next()) {
                    System.out.printf("%-5d %-15s %-10.2f %-15s %-25s%n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("salary"),
                        rs.getString("department"),
                        rs.getString("email"));
                }
            }
        }
    }

    // ========== Main Method - Demo ==========

    public static void main(String[] args) {
        try (Connection conn = getConnection()) {
            System.out.println("Connected to database successfully!");

            // Display initial data
            displayAllEmployees(conn);

            // UPDATE Examples
            System.out.println("\n========== UPDATE Operations ==========");
            
            // 1. Update single employee's salary
            System.out.println("\n1. Update salary of employee with ID 1:");
            updateEmployeeSalary(conn, 1, 55000);

            // 2. Update department
            System.out.println("\n2. Update department of employee with ID 4:");
            updateEmployeeDepartment(conn, 4, "Marketing");

            // 3. Increase salary by percentage for a department
            System.out.println("\n3. Increase IT salary by 15%:");
            increaseSalaryByPercentage(conn, "IT", 15);

            // 4. Update multiple columns
            System.out.println("\n4. Update multiple columns for ID 5:");
            updateMultipleColumns(conn, 5, "Ravi Kumar", 65000, "Manager");

            // Display after updates
            displayAllEmployees(conn);

            // DELETE Examples
            System.out.println("\n========== DELETE Operations ==========");

            // 1. Delete by ID
            System.out.println("\n1. Delete employee with ID 6:");
            deleteEmployeeById(conn, 6);

            // 2. Delete by email
            System.out.println("\n2. Delete employee with email 'shyam@company.com':");
            deleteEmployeeByEmail(conn, "shyam@company.com");

            // 3. Delete by department
            System.out.println("\n3. Delete all employees from Sales department:");
            deleteEmployeesByDepartment(conn, "Sales");

            // 4. Delete low salary employees
            System.out.println("\n4. Delete employees with salary below 40000:");
            deleteLowSalaryEmployees(conn, 40000);

            // 5. Delete with multiple conditions
            System.out.println("\n5. Delete IT employees with salary below 50000:");
            deleteWithMultipleConditions(conn, "IT", 50000);

            // Display final data
            displayAllEmployees(conn);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
