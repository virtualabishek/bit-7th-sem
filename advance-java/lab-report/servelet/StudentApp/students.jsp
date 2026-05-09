<%@ page import="java.sql.*" %>
<html>
<head>
    <title>Student Records</title>
</head>
<body>
<h2>Student Records</h2>
<table border="1" cellpadding="10">
<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Age</th>
    <th>Course</th>
    <th>Marks</th>
</tr>
<%
String url =
"jdbc:mysql://localhost:3306/student_java?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
String user = "abi";
String pass = "imp2083";
try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conn =
        DriverManager.getConnection(url, user, pass);
    String sql = "SELECT * FROM students";
    Statement st = conn.createStatement();
    ResultSet rs = st.executeQuery(sql);
    while(rs.next()) {
%>
<tr>
    <td><%= rs.getInt("id") %></td>
    <td><%= rs.getString("name") %></td>
    <td><%= rs.getInt("age") %></td>
    <td><%= rs.getString("course") %></td>
    <td><%= rs.getDouble("marks") %></td>
</tr>
<%
    }
    conn.close();
} catch(Exception e) {
    out.println(e);
}
%>
</table>
</body>
</html>
