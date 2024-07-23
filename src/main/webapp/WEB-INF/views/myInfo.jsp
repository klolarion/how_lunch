
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ include file="taglib.jsp"%>
<html>
<head>
    <title>My info</title>
</head>
<body>
<%@ include file="header.jsp"%>

<h1>My info</h1>
<p>Name : ${username}</p>
<p></p>
<table border="1">
    <tr>
        <th>account number</th>
        <th>balance</th>
        <th colspan="3">to do</th>
    </tr>
    <c:forEach var="account" items="${accounts}">
        <tr>
            <td>
                <a href="${pageContext.request.contextPath}/bank/view?path=accountView&accountNumber=${account.accountNumber}">${account.accountNumber}</a>
            </td>
            <td>${account.balance}</td>
            <td>
                <a href="${pageContext.request.contextPath}/bank/view?path=deposit&accountNumber=${account.accountNumber}&balance=${account.balance}">deposit</a>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/bank/view?path=withdraw&accountNumber=${account.accountNumber}&balance=${account.balance}">withdraw</a>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/bank/view?path=transfer&accountNumber=${account.accountNumber}&balance=${account.balance}">transfer</a>
            </td>
        </tr>
    </c:forEach>
</table>

<br>
<br>
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
