<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<html>
<body>

    ${registration}
    <c:choose>
        <c:when test="${loggedUser.roleId == 1}">
            You are logged as Admin <br>
            <form action="controller" method="get">
                <input type="hidden" name="command" value="logout">
                <input type="submit" value="Logout">
            </form>

        </c:when>
        <c:when test="${loggedUser.roleId == 2}">
            You are logged as ${loggedUser.login} <br>
            <form action="controller" method="get">
                <input type="hidden" name="command" value="logout">
                <input type="submit" value="Logout">
            </form>

        </c:when>
        <c:otherwise>
            <form action="controller" method="post">
                <input type="hidden" name="command" value="login"><br>
                <input name="login" value="user2"><br>
                <input name="password" type="password" value="user2pass"><br>
                <input type="submit" value="Login">
            </form>
            <form action="controller" method="post">
                <input type="hidden" name="command" value="register">
                <input type="submit" value="Register">
            </form>

        </c:otherwise>
    </c:choose>

    <form action="controller" method="get">
        <input type="hidden" name="command" value="listLiners">
        <input type="submit" value="Liner list">
    </form>
    <form action="controller" method="get">
        <input type="hidden" name="command" value="listCruises">
        <input type="submit" value="Cruise list">
    </form>

</body>
</html>