
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ include file="header.jsp"%>
<%@ include file="taglib.jsp"%>
<html>
<head>
    <title>Deposit</title>
</head>
<body>
<%
    String accountNumber = request.getParameter("accountNumber");
    String balance = request.getParameter("balance");
%>

<h1>Deposit</h1>
<p>My account : ${accountNumber}</p>
<p>Current balance : ${balance}</p>
<form action="${pageContext.request.contextPath}/bank/view?path=doDeposit&accountNumber=${accountNumber}&userId=1" method="post">
    Amount : <input name="amount"><br>
    <input type="submit" value="Submit">

</form>
</body>
</html>
