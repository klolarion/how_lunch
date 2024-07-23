
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ include file="header.jsp"%>
<%@ include file="taglib.jsp"%>
<html>
<head>
    <title>Account view</title>
</head>
<body>
<%@ include file="header.jsp"%>

<h1>Account info</h1>
<p>Account number : ${account.accountNumber}</p>
<p></p>

<br>
<table border="1">
    <tr>
        <th>Type</th>
        <th>Amount</th>
        <th>Main account</th>
        <th>Target account</th>
        <th>Date</th>

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

</body>
</html>
