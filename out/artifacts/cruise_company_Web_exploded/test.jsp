<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
    Hello1
    <c:forEach items = "${users}" var = "user">
        ${user.login}
        ${user.password}
        <br>
    </c:forEach>
</body>
</html>