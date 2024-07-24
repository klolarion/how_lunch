
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ include file="header.jsp"%>
<%@ include file="taglib.jsp"%>
<html>
<head>
    <title>Transfer</title>
</head>
<body>
<h1>Transfer</h1>
<p>My account : ${accountNumber}</p><br>
<p>Current balance : ${balance}</p>
<form action="${pageContext.request.contextPath}/bank/view?path=doTransfer" method="post">
    <input name="myAccountNum" value="${accountNumber}" hidden>
  Target account : <input name="targetAccountNum"><br>
  Amount : <input name="amount"><br>
  <input type="submit" value="Submit">
</form>

</body>
</html>
