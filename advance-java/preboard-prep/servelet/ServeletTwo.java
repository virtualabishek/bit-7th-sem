import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class ServeletTwo extends GenericServlet {
  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {
    res.setContentType("text/html");
    PrintWriter out = res.getWriter();
    out.println("<html><body><h1>Hello Generic Servlet (Extended)</h1></body></html>");
  }
}
