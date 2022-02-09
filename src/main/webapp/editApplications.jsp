<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Edit applications</title>
</head>
<body>
<a href="index.jsp">Main page</a> <br>

    <form action="controller" method="post">
        <input type="hidden" name="command" value="updateApplications">
        <input name="Login" value="${application.login}" disabled>
        <input name="Name" value="${application.name}" disabled>
        <input name="Surname" value="${application.surname}" disabled>
        <input name="Cruise id" value="${application.cruiseId}" disabled>
        <select name="Status">
            <c:forEach items="${statuses}" var="status">
                <option value="${status}"<c:if test="${application.status == status}">selected</c:if>>${status}</option>
            </c:forEach>
        </select>
        <input type="hidden" name="Birthdate" value="${application.birthdate}">
        <input type="hidden" name="Id" value="${application.id}">
        <input type="submit" value="Update">
    </form>

</body>
</html>
