<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Admin panel</title>
</head>
<body>
<a href="index.jsp">Main page</a> <br>
  <c:if test="${loggedUser.roleId != 1}">
    You are not permitted here!
  </c:if>
    <c:if test="${loggedUser.roleId == 1}">
        <c:forEach items="${cruises}" var="cruise">
            <form>
                <input type="hidden" name="command" value="updateCruises">
                <input name="Name" value="${cruise.name}">
                <input name="Liner" value="${cruise.liner.name}">
                <input name="Start time" value="${cruise.startTime}">
                <input name="End time" value="${cruise.endTime}">
                <input type="hidden" name="Id" value="${cruise.id}">
                <input type="submit" value="Update">
            </form>
        </c:forEach>
    </c:if>
</body>
</html>
