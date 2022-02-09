<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Admin panel</title>
</head>
<body>
<a href="index.jsp">Main page</a> <br>
        <c:forEach items="${requestScope.cruises}" var="cruise">
            <form action="controller" method="post">
                <input type="hidden" name="command" value="updateCruises">
                <input name="Name" value="${cruise.name}">
                <select name="Liner">
                    <c:forEach items="${requestScope.liners}" var="liner">
                        <option value="${liner.name}" <c:if test="${cruise.liner.name == liner.name}">selected</c:if><%--TODO TRANSFORM IF TO TAGFILE--%>>${liner.name}</option>
                    </c:forEach>
                </select>
                <input name="Start time" value="${cruise.startTime}">
                <input name="End time" value="${cruise.endTime}">
                <input type="hidden" name="Id" value="${cruise.id}">
                <input type="submit" value="Update">
            </form>
        </c:forEach>
</body>
</html>
