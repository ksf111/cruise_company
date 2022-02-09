<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book tickets</title>
</head>
<body>
<a href="index.jsp">Main page</a> <br>
    <form action="controller" method="post">
        <input type="hidden" name="command" value="submitApplication">
        <input name="Cruise name" value="${cruiseName}" disabled>
        <input type="hidden" name="CruiseId" value="${cruiseId}">
        <input name="Login" value="${loggedUser.login}">
        <input name="Name">
        <input name="Surname">
        <input name="Birthdate">
        <input type="submit" value="Submit application">
    </form>
</body>
</html>
