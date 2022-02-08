<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register page</title>
</head>
<body>
<form action="controller" method="post">
  <input type="hidden" name="command" value="register"><br>
  <input name="login" value=""><br>
  <input type="password" name="password" value=""><br>
  <input type="submit" value="Register">
</form> <br>
${requestScope.error}
</body>
</html>
