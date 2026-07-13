import java.io.*;
import java.sql.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class FeedbackServlet extends HttpServlet {

    static final String URL =
        System.getenv().getOrDefault("DB_URL", "jdbc:mariadb://localhost:3306/student_java");

    static final String USER = System.getenv("DB_USER");
    static final String PASS = System.getenv("DB_PASSWORD");

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        String name =
                request.getParameter("name");

        String email =
                request.getParameter("email");

        String message =
                request.getParameter("message");

        try {

            Class.forName("org.mariadb.jdbc.Driver");

            Connection conn =
                DriverManager.getConnection(
                    URL,
                    USER,
                    PASS
                );

            String sql =
                "INSERT INTO feedback(name, email, message) VALUES (?, ?, ?)";

            PreparedStatement pst =
                conn.prepareStatement(sql);

            pst.setString(1, name);
            pst.setString(2, email);
            pst.setString(3, message);

            pst.executeUpdate();

            conn.close();

            response.sendRedirect("success.jsp");

        } catch(Exception e) {

            response.getWriter().println(e);

        }
    }
}
