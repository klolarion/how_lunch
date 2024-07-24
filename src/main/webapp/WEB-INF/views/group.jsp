
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ include file="header.jsp"%>
<%@ include file="taglib.jsp"%>
<html>
<head>
    <title>Group</title>
</head>
<body>
<h2>Generate Lunch Teams</h2>
<form action="${pageContext.request.contextPath}/group?path=doGroup" method="post">
    <label for="playerNumber">Number of Players:</label>
    <input type="number" id="playerNumber" name="playerNumber" required><br><br>

    <label for="days">Number of Days:</label>
    <input type="number" id="days" name="days" required><br><br>

    <label for="teamSize">Team Size:</label>
    <input type="number" id="teamSize" name="teamSize" required><br><br>

    <input type="submit" value="Generate">
</form>

<h2>Lunch Team Results</h2>
<c:forEach var="team" items="${teams}">
    <h3>Day ${team.day}</h3>
    <c:forEach var="group" items="${team.teams}">
        <p>Team:</p>
        <ul>
            <c:forEach var="player" items="${group}">
                <li>${player}</li>
            </c:forEach>
        </ul>
    </c:forEach>
</c:forEach>
<a href="generateTeams">Back</a>

</body>
</html>
