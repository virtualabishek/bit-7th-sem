
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TransactionMoney {

    static final String URL = "jdbc:mysql://localhost:3306/student_java";
    static final String USER = "abi";
    static final String PASS = "imp2083";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Money Transfer System.");
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            displayAccounts(conn);
            System.out.println("From Account id: ");
            int formId = sc.nextInt();
            System.out.println("To account id: ");
            int toId = sc.nextInt();
            System.out.println("Amount to Transfer: ");
            double amount = sc.nextDouble();
            transfer(conn, formId, toId, amount);
            System.out.println("After Transfer: ");
            displayAccounts(conn);
        } catch (SQLException e) {
            System.out.println("DB Error: " + e.getMessage());
        }
    }

    static void displayAccounts(Connection conn) throws SQLException {
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery("SELECT * FROM accounts")) {
            System.out.printf("%-5s %-15s %-10s%n", "ID", "Owner", "Balance");
            while (rs.next()) {
                System.out.printf("%-5d %-15s %-10.2f%n",
                        rs.getInt("id"),
                        rs.getString("owner"),
                        rs.getDouble("balance"));

            }
        }
    }

    static void transfer(Connection conn, int fromId, int toId, double amount) {
        try {
            conn.setAutoCommit(false);
            String checkSql = "SELECT balance FROM accounts WHERE id = " + fromId;
            PreparedStatement checkps = conn.prepareStatement(checkSql);
            ResultSet rs = checkps.executeQuery();
            if (!rs.next()) {
                throw new SQLException("Sender account not found");
            }
            String dedeuctSql = "UPDATE accounts SET balance = balance - ? WHERE id = ?";
            PreparedStatement deductPs = conn.prepareStatement(dedeuctSql);
            deductPs.setDouble(1, amount);
            deductPs.setInt(2, fromId);
            deductPs.executeUpdate();
            String addSql = "UPDATE accounts SET balance = balance + ? WHERE id = ? ";
            PreparedStatement addPs = conn.prepareStatement(addSql);
            addPs.setDouble(1, amount);
            addPs.setInt(2, toId);
            int rows = addPs.executeUpdate();
            if (rows == 0) {
                throw new SQLException("Receiver account not found!");
            }
            conn.commit();
            System.out.println("Transfer of" + amount + "successfull!");
        } catch (SQLException e) {
            System.out.println("Transfer failed: " + e.getMessage());
            System.out.println("Rolling back.");
            try {
                conn.rollback();
                System.out.println("Rollback successfull. No changes made in db.");
            } catch (SQLException re) {
                System.out.println("Rollback failed. " + re.getMessage());
            }
        } finally {
            try {
                conn.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
