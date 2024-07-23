
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.layerd_bank.*, java.util.*" %>
<%@ page import="com.example.layerd_bank.dao.UserDAO" %>
<%@ page import="com.example.layerd_bank.dao.UserDAOImpl" %>
<html>
<head>
    <title>Manage user</title>
</head>
<body>
<%@ include file="header.jsp"%>
<h1>Manage user</h1>
<%
    UserDAO userDAO = new UserDAOImpl();
%>

<form>
    <label for="username">Name : </label>
    <input id="username" name="username" placeholder="Enter name"><br>
    <label for="email">Email : </label>
    <input id="email" name="email" placeholder="Enter email" type="email"><br>
    <button>Submit</button>
</form>
</body>
</html>
