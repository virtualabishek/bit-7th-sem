import java.sql.*;
public class ConnectDb {
  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
  static final String DB_URL =  "jdbc:mysql//localhost/java_exam";
  public static void main(String[] args) {
    Connection conn = null;
    Statement stmt = null;
    try {
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Connecting to DB");
      String user = System.getenv("DB_USER");
      String password = System.getenv("DB_PASSWORD");
      conn = DriverManager.getConnection(DB_URL, user, password);
      System.out.println("Creating Statemment");
      stmt = conn.createStatement();
      String sql;
      sql = "SELECT id, name FROM students";
      ResultSet rs = stmt.executeQuery(sql);
      while(rs.next()) {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        System.out.print("ID: " + id);
        System.out.println("Name: " + name);
      }
      rs.close();
      stmt.close();
      conn.close();
    }
    catch(SQLException se) {
        se.printStackTrace();
    }
  }
}
