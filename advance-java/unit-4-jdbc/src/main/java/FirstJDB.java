import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FirstJDB {
    public static void main(String[] args) {
        String url = System.getenv().getOrDefault(
                "DB_URL",
                "jdbc:mysql://localhost:3306/java_exam?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC"
        );
        String user = System.getenv().getOrDefault("DB_USER", "abi");
        String password = System.getenv("DB_PASSWORD");

        String sql = "SELECT id, name FROM students";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                System.out.println(rs.getInt("id") + " - " + rs.getString("name"));
            }
            System.out.println("Connected and query executed successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
