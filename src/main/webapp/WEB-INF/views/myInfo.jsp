
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ include file="taglib.jsp"%>
<%@ include file="header.jsp"%>
<html>
<head>
    <title>My info</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>


<h1>Name : ${username}</h1>
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
                <a href="${pageContext.request.contextPath}/account?accountNumber=${account.accountNumber}">${account.accountNumber}</a>
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

<p>New account</p>
<form action="${pageContext.request.contextPath}/account/view?path=newAccount" method="post">
    Account number1 : <input name="accountNumber1" maxlength="3" placeholder="000"><br>
    Account number2 : <input name="accountNumber2" maxlength="3" placeholder="000"><br>
    Account number3 : <input name="accountNumber3" maxlength="3" placeholder="000"><br>
    <input type="submit" value="Submit">
</form>


<br>
<br>


<table border="1">
    <tr>
        <th>Type</th>
        <th>Amount</th>
        <th>Main account</th>
        <th>Target account</th>
        <th><a href="${pageContext.request.contextPath}/bank?accountNumber=${accountNumber}&order=asc">^</a> Date <a href="${pageContext.request.contextPath}/bank?accountNumber=${accountNumber}&order=desc">v</a></th>

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
                <a href="/bank?userId=${userId}&page=${i}">${i}</a>
            </c:otherwise>
        </c:choose>
    </c:forEach>
</div>

</body>
</html>
