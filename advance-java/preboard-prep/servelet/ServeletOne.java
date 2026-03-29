import java.io.*;
import jakarta.servlet.*;

public class ServeletOne implements Servlet {
  public void init(ServletConfig config) throws ServletException {
    System.out.println("Servet being initialized");
  }

  public void service(ServletRequest req, ServletResponse res) 
    throws ServletException, IOException {
    res.setContentType("text/html");
    PrintWriter out = res.getWriter();
    out.println("<html><body>");
    out.println("<h1>Hello from the Servlet Interface implementation!</h1>");
    out.println("</body></html>");
  }

  public void destroy() {
    System.out.println("Servelet destroy");
  }
  public static void main(String[] args) {
    new ServeletOne();
  }
  }
