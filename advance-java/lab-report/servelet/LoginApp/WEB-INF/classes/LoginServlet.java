import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;


public class LoginServlet extends HttpServlet {
	protected void doPost (
			HttpServletRequest request,
			HttpServletResponse response 
			) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String validUser = System.getenv("LOGIN_USER");
		String validPass = System.getenv("LOGIN_PASS");
		if(username.equals(validUser)
            && password.equals(validPass)) {

            HttpSession session =
                request.getSession();

            session.setAttribute("user", username);

            response.sendRedirect("welcome.jsp");

        } else {

            response.getWriter().println(
                "<h1>Invalid Username or Password</h1>"
            );
        }
    }
}

