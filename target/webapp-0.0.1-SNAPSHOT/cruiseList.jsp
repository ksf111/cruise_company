<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Cruises</title>
</head>
<body>
<a href="index.jsp">Main page</a> <br>
    <table border="1" align="left">
        <tr>
            <th>Name</th>
            <th>Liner</th>
            <th>Start time</th>
            <th>End time</th>
        </tr>
        <c:forEach items="${cruises}" var="cruise">
            <tr>
                <td>
                    <c:out value="${cruise.name}"></c:out>
                </td>
                <td>
                    <c:out value="${cruise.liner.name}"></c:out>
                </td>
                <td>
                    <c:out value="${cruise.startTime}"></c:out>
                </td>
                <td>
                    <c:out value="${cruise.endTime}"></c:out>
                </td>
                <c:if test="${loggedUser.roleId == 2}">
                    <td>
                        <form action="controller" method="post">
                        <input type="hidden" name="command" value="bookTicket">
                        <input type="submit" value="Book tickets">
                        <input type="hidden" name="loggedUser" value="${loggedUser.login}">
                        </form>
                    </td>
                </c:if>
            </tr>
        </c:forEach>
    </table>

<c:if test="${loggedUser.roleId == 1}">
    <form action="controller" method="get">
        <input type="hidden" name="command" value="editCruises">
        <input type="submit" value="Edit">
    </form>
</c:if>
</body>
</html>
