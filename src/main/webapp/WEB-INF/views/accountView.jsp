<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ include file="header.jsp"%>
<%@ include file="taglib.jsp"%>
<html>
<head>
    <title>Account view</title>
</head>
<body>

<h1>Account info</h1>
<p>Account number : ${accountNumber}</p>
<p></p>

<br>
<table border="1">
    <tr>
        <th>Type</th>
        <th>Amount</th>
        <th>Main account</th>
        <th>Target account</th>
        <th><a href="${pageContext.request.contextPath}/account?accountNumber=${accountNumber}&order=asc">^</a> Date <a href="${pageContext.request.contextPath}/account?accountNumber=${accountNumber}&order=desc">v</a></th>
    </tr>
    <c:forEach var="transaction" items="${transactions}">
        <tr>
            <td>${transaction.type}</td>
            <td>${transaction.amount}</td>
            <td>${transaction.mainAccount}</td>
            <td>${transaction.targetAccount}</td>
            <td>${transaction.regDate}</td>
        </tr>
    </c:forEach>
</table>

<div>
    <c:forEach var="i" begin="1" end="${totalPages}">
        <c:choose>
            <c:when test="${i == currentPage}">
                <strong>${i}</strong>
            </c:when>
            <c:otherwise>
                <a href="/account?userId=${userId}&accountNumber=${accountNumber}&page=${i}">${i}</a>
            </c:otherwise>
        </c:choose>
    </c:forEach>
</div>

</body>
</html>