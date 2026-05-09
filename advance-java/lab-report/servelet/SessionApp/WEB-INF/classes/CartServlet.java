import java.io.*;
import java.util.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class CartServlet extends HttpServlet {

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        String product =
                request.getParameter("product");

        HttpSession session =
                request.getSession();

        ArrayList<String> cart =
                (ArrayList<String>) session.getAttribute("cart");

        if(cart == null) {
            cart = new ArrayList<>();
        }

        cart.add(product);

        session.setAttribute("cart", cart);

        response.sendRedirect("cart.jsp");
    }
}
