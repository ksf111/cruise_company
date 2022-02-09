<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Application list</title>
    <style>
        table{
            border:1px solid #000;
            border-collapse:collapse;
            text-align: center;
        }
        th{
            border:1px solid #000;
            text-align: center;
        }
        td{
            border:1px solid #000;
            text-align: center;
        }
        button{
            background-color: #4CAF50; /* Green */
            border: none;
            color: white;
            padding: 10px 25px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
        }

    </style>
</head>
<body>
<a href="index.jsp">Main page</a> <br>
<table>
    <colgroup>
        <col span="1" style="width: auto;">
        <col span="1" style="width: auto;">
        <col span="1" style="width: auto;">
        <col span="1" style="width: auto;">
        <col span="1" style="width: auto;">
        <col span="1" style="width: auto;">
        <col span="1" style="width: auto;">
    </colgroup>
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
            <td>${application.login}</td>
            <td>${application.name}</td>
            <td>${application.surname}</td>
            <td>${application.birthdate}</td>
            <td>${application.status}</td>
            <td>${application.cruiseId}</td>
            <c:if test="${loggedUser.roleId == 1}">
                <td>
                <form action="controller" method="get">
                    <input type="hidden" name="command" value="editApplications">
                    <input type="hidden" name="Id" value="${application.id}">
                    <button type="submit" value="Edit">Edit</button>
                </form>
                </td>
            </c:if>
        </tr>
    </c:forEach>
</table>
</body>
</html>
