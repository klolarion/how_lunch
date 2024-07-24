<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ include file="taglib.jsp"%>
<html>
<head>
    <title>Account view</title>
    <style>
        /* Global Styles */
        body {
            font-family: Arial, sans-serif;
            background-color: #f7f7f7;
            margin: 0;
            padding: 20px;
        }

        /* Link Styles */
        a {
            color: #6c757d;
            text-decoration: none;
        }

        a:hover {
            color: #333333;
            text-decoration: none;
        }

        /* updown style */
        .updown {
            color: white;
            text-decoration: none;
        }

        .updown:hover {
            color: #333333;
            text-decoration: none;
        }

        /* Header Styles */
        h1 {
            color: #333;
            text-align: center;
            margin-bottom: 20px;
        }

        .name {
            text-align: left;
            margin: 20px 0;
            width: 50%; /* Match table width */
            margin-left: auto;
            margin-right: auto;
        }

        /* Table Styles */
        table {
            width: 50%; /* Reduced width */
            margin: 0 auto; /* Center the table */
            border-collapse: collapse;
            margin-bottom: 20px;
            box-shadow: 0 2px 3px rgba(0, 0, 0, 0.1);
        }

        th, td {
            padding: 10px;
            text-align: center;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #6c757d;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        /* Pagination Styles */
        .pagination {
            text-align: center;
            margin-top: 20px;
        }

        .pagination a {
            color: #6c757d;
            padding: 8px 16px;
            text-decoration: none;
            border: 1px solid #ddd;
            margin: 0 2px;
        }

        .pagination a:hover {
            background-color: #ddd;
        }

        .pagination strong {
            padding: 8px 16px;
            margin: 0 2px;
            border: 1px solid #6c757d;
            background-color: #6c757d;
            color: white;
        }
    </style>
</head>
<body>
<div style="text-align: center">
    <%@ include file="header.jsp" %>
</div>
<h1>Account info</h1>
<p class="name">Account number : ${accountNumber}</p>
<table border="1">
    <tr>
        <th>Type</th>
        <th>Amount</th>
        <th>Main account</th>
        <th>Target account</th>
        <th>Date
            <a class="updown" href="${pageContext.request.contextPath}/account?accountNumber=${accountNumber}&order=asc">↑</a>
            <a class="updown" href="${pageContext.request.contextPath}/account?accountNumber=${accountNumber}&order=desc">↓</a></th>
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

<div class="pagination">
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