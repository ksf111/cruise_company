<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Application list</title>
</head>
<body>
<a href="index.jsp">Main page</a> <br>
<table border="1" align="left">
    <tr>
        <th>Login</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Birthdate</th>
        <th>Status</th>
        <th>Cruise id</th>
    </tr>
    <c:forEach items="${applications}" var="application">
        <tr>
            <td><c:out value="${application.login}"></c:out></td>
            <td><c:out value="${application.name}"></c:out></td>
            <td><c:out value="${application.surname}"></c:out></td>
            <td><c:out value="${application.birthdate}"></c:out></td>
            <td><c:out value="${application.status}"></c:out></td>
            <td><c:out value="${application.cruiseId}"></c:out></td>
            <c:if test="${loggedUser.roleId == 1}">
                <td>
                <form action="controller" method="get">
                    <input type="hidden" name="command" value="editApplications">
                    <input type="submit" value="Edit">
                    <input type="hidden" name="Id" value="${application.id}">
                </form>
                </td>
            </c:if>
        </tr>


    </c:forEach>
</table>
</body>
</html>
