<%@ page session="true" %>

<html>
<head>
    <title>Welcome</title>
</head>
<body>

<h1>Login Successful!</h1>

Welcome, <%= session.getAttribute("user") %>

</body>
</html>
