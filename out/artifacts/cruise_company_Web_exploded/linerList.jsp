<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<html>
<head>
    <title>Liners</title>
</head>
<body>
<a href="index.jsp">Main page</a> <br>
    <table align="left" border="1">
        <tr>
            <th>Name</th>
            <th>Passengers</th>
            <th>Crew</th>
        </tr>
        <c:forEach items="${liners}" var="liner">
            <tr>
                <td>
                    <c:out value="${liner.name}"></c:out>
                </td>
                <td>
                    <c:out value="${liner.passengers}"></c:out>
                </td>
                <td>
                    <c:out value="${liner.crew}"></c:out>
                </td>
                <c:if test="${loggedUser.roleId == 2}">
                <td>
                    <a href="bookTicket.jsp">Book tickets</a>
                </td>
                </c:if>
            </tr>
        </c:forEach>
    </table>
</body>
</html>