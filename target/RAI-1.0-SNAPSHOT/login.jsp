<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="LogInServlet" method="post">
    User name: <input type="text" name="username">
    <br>
    Password: <input type="text" name="password">
    <br>
    <input type="submit" value="Login">
    <input type="reset" value="Cancel">
</form>
</body>
</html>
