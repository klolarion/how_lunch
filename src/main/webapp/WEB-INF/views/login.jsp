<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>login</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
    <style>
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
        .main {
            flex: 1;
            display: flex;
            justify-content: center;
            align-items: center;
            margin: 100px auto;
        }
        .login-container {
            width: 100%;
            max-width: 400px; /* Increased max-width */
            padding: 20px;
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            box-sizing: border-box; /* Ensure padding is included in width */
        }
        .login-container h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        .form-group {
            display: flex;
            flex-direction: column; /* Align items vertically */
            gap: 10px;
            margin-bottom: 20px;
        }
        .btn-custom {
            width: 30%;
            background-color: #6c757d; /* Primary color for both buttons */
            color: #fff;
            border: none;
            border-radius: 4px;
            padding: 10px;
            text-align: center;
            cursor: pointer;
            text-decoration: none; /* For anchor tag */
        }
        .btn-custom:hover {
            background-color: #5a6268; /* Darker shade for hover effect */
        }
        .btn-group {
            display: flex;
            gap: 10px;
            justify-content: center; /* Adjust the gap between buttons */
        }
    </style>
</head>
<body>
<div style="text-align: center">
    <%@ include file="header.jsp" %>
</div>
<div class="main">
    <div class="login-container">
        <h2>Login</h2>
        <form action="${pageContext.request.contextPath}/user/doLogin" method="post">
            <div class="form-group">
                <input type="email" class="form-control" placeholder="Enter email" id="email" name="email" required>
                <input type="password" class="form-control" placeholder="Enter password" id="password" name="password" required>
            </div>
            <div class="btn-group">
                <button type="submit" value="Login" class="btn btn-custom">로그인</button>
                <a href="${pageContext.request.contextPath}/user/register" class="btn btn-secondary btn-custom">회원가입</a>
            </div>
        </form>
    </div>
</div>

<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>