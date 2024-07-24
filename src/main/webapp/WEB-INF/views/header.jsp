<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ include file="taglib.jsp" %>
<html>
<head>
    <title>Header</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/bank/view">Home</a> |
<c:choose>
    <c:when test="${cookie.UID != null}">
        <a href="${pageContext.request.contextPath}/user/logout">Logout |</a>
    </c:when>
    <c:otherwise>
        <a href="${pageContext.request.contextPath}/user/login">Login</a> |
        <a href="${pageContext.request.contextPath}/user/register">Register |</a>
    </c:otherwise>
</c:choose>
<a href="${pageContext.request.contextPath}/group/view">Group</a>
</body>
</html>