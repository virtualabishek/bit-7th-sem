<%@ page import="java.util.*" %>

<html>
<head>
    <title>Shopping Cart</title>
</head>
<body>

<h2>Your Cart</h2>

<%
    ArrayList<String> cart =
        (ArrayList<String>) session.getAttribute("cart");

    if(cart == null || cart.isEmpty()) {
%>

<p>Cart is empty.</p>

<%
    } else {

        for(String item : cart) {
%>

<p><%= item %></p>

<%
        }
    }
%>

<br>

<a href="product.jsp">Back to Products</a>

</body>
</html>
