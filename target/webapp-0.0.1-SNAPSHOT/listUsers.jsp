<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>

<c:forEach items="${users}" var="user">
	${user.login}
	${user.name}
	
	<c:if test="${loggedUser.role == 'admin' }">
		<a href="controller?command=confirmDeleteUser&id=${user.id}">delete</a>	
	</c:if>
	<br>
	
</c:forEach>

</body>
</html>