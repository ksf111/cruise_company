<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Cruises</title>
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
    </style>
</head>
<body>
<a href="index.jsp">Main page</a> <br>
${sortingNames}
${sortingLiners}
${dateStart}
${dateEnd}
    <table>
        <colgroup>
            <col span="1" style="width: 15%;">
            <col span="1" style="width: 15%;">
            <col span="1" style="width: 30%;">
            <col span="1" style="width: 30%;">
        </colgroup>
        <tr>
            <thead>
            <th>Name</th>
            <th>Liner</th>
            <th>Start time</th>
            <th>End time</th>
            </thead>
        </tr>
        <tr>
            <td>
                <c:if test="${sortingNames == 'descendingNames'}">
                <form action="controller" method="get">
                    <input type="hidden" name="command" value="sortingAscendingName">
                    <button type="submit" value="">&#8595</button>
                </form>
                </c:if>
                <c:if test="${sortingNames == 'ascendingNames'}">
                    <form action="controller" method="get">
                        <input type="hidden" name="command" value="sortingDescendingName">
                        <button type="submit" value="">&#8593</button>
                    </form>
                </c:if>
                <c:if test="${sortingNames == null}">
                    <form action="controller" method="get">
                        <input type="hidden" name="command" value="sortingDescendingName">
                        <button type="submit" value="">&#8595</button>
                    </form>
                </c:if>
                </td>
            <td><c:if test="${sortingLiners == 'descendingLiners'}">
                <form action="controller" method="get">
                    <input type="hidden" name="command" value="sortingAscendingShip">
                    <button type="submit" value="">&#8595</button>
                </form>
            </c:if>

                <c:if test="${sortingLiners == 'ascendingLiners'}">
                    <form action="controller" method="get">
                        <input type="hidden" name="command" value="sortingDescendingShip">
                        <button type="submit" value="">&#8593</button>
                    </form>
                </c:if>
                <c:if test="${sortingLiners == null}">
                    <form action="controller" method="get">
                        <input type="hidden" name="command" value="sortingDescendingShip">
                        <button type="submit" value="">&#8595</button>
                    </form>
                </c:if>
                </td>
            <td>
                <form action="controller" method="get">
                    <input type="hidden" name="command" value="dateStart">
                    <input type="date" name="dateStart" value="${dateStart}" min="2022-01-01" max="2022-12-31" step="1"> <br>
                    <input type="date" name="dateEnd" value="${dateEnd}" min="${dateStart}" max="2022-12-31" step="1"<c:if test="${dateStart == null}">disabled</c:if>><br>
                    <button type="submit" value="">&#8594</button>
                </form>
                <c:if test="${dateStart != null && dateEnd != null}">
                    <form action="controller" method="get">
                        <input type="hidden" name="command" value="listCruises">
                        <button type="submit">Reset</button>
                    </form>
                </c:if>
            </td>
            <td></td>
        </tr>
        <c:forEach items="${cruises}" var="cruise">
            <tr>
                <tbody>
                <td>${cruise.name}</td>
                <td>${cruise.liner.name}</td>
                <td>${cruise.startTime}</td>
                <td>${cruise.endTime}</td>
                <c:if test="${loggedUser.roleId == 2}">
                    <td>
                        <form action="controller" method="post">
                            <input type="hidden" name="command" value="bookTicket">
                            <input type="submit" value="Book tickets">
                            <input type="hidden" name="loggedUser" value="${loggedUser.login}">
                            <input type="hidden" name="cruiseId" value="${cruise.id}">
                        </form>
                    </td>
                </c:if>
                </tbody>
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
