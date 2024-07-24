
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ include file="header.jsp"%>
<%@ include file="taglib.jsp"%>
<html>
<head>
    <title>Withdraw</title>
</head>
<body>

<h1>Withdraw</h1>
<p>My account : ${accountNumber}</p><br>
<p>Current balance : ${balance}</p>
<form action="${pageContext.request.contextPath}/bank/view?path=doWithdraw" method="post">
    <input name="accountNumber" value="${accountNumber}" hidden>
  Amount : <input name="amount"><br>
  <input type="submit" value="Submit">
</form>
</body>
</html>
