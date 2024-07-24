<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ include file="taglib.jsp" %>
<html>
<head>
    <title>My info</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
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

        .main {
            width: 50%;
            margin: 0 auto;
        }

        /* Table Styles */
        table {
            width: 100%; /* Reduced width */
            margin: 0 auto; /* Center the table */
            border-collapse: collapse;
        }

        th, td {
            padding: 10px;
            border-bottom: 1px solid #ddd;
            text-align: center;
        }

        th {
            text-align: center;
            background-color: #6c757d;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        /* Pagination Styles */
        .pagination {
            justify-content: center;
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
        .newaccount{
            text-align: center;
        }

        .btn-custom {
            height: 32px;
            background-color: #6c757d; /* Primary color for both buttons */
            color: #fff;
            border: none;
            border-radius: 4px;
            text-align: center;
            cursor: pointer;
            text-decoration: none; /* For anchor tag */
        }
        .btn-custom:hover {
            background-color: #5a6268; /* Darker shade for hover effect */
        }
    </style>
</head>
<body>

<div style="text-align: center">
    <%@ include file="header.jsp" %>
</div>
<p class="name">Name : ${username}</p>
<div class="main">




    <table border="1">
        <tr>
            <th class="account-number">account number</th>
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
    <div class="newaccount">
        <h2>New account</h2>
        <form action="${pageContext.request.contextPath}/account/view?path=newAccount" method="post">
            Account number : <input name="accountNumber1" maxlength="3" placeholder="000"> -
            <input name="accountNumber2" maxlength="3" placeholder="000"> -
            <input name="accountNumber3" maxlength="3" placeholder="000">
            <div class="btn-group">
                <button type="submit" value="Submit" class="btn btn-custom">Submit</button>
            </div>
        </form>
    </div>
    <br>
    <table border="1">
        <tr>
            <th>Type</th>
            <th>Amount</th>
            <th>Main account</th>
            <th>Target account</th>
            <th>Date
                <a class="updown"
                   href="${pageContext.request.contextPath}/bank?accountNumber=${accountNumber}&order=asc">↑</a>
                <a class="updown"
                   href="${pageContext.request.contextPath}/bank?accountNumber=${accountNumber}&order=desc">↓</a></th>

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
                    <a href="/bank?userId=${userId}&page=${i}">${i}</a>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
