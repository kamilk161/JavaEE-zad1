<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv='Content-Type' content='text/html; charset=utf-8'>
    <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css'>
    <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css'>
    <script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js'></script>
    <title>Dodawanie</title>
</head>
<body>
    <jsp:useBean id="user" class="pl.kkrampa.lab1.domain.User" scope="session" />
    <jsp:setProperty name="user" property="*" />
    <jsp:useBean id="users" class="pl.kkrampa.lab1.service.UserService" scope="application" />

    <c:set var="created" value="${users.addUser(user)}" scope="session"/>
    <c:choose>
        <c:when test="${created == true}">
            <c:redirect url="index.jsp"/>
        </c:when>
        <c:otherwise>
            <c:set var="login" value="Login zajęty" scope="request"/>
            <c:if test="${user.password != user.rpassword}">
                <c:set var="password" value="Hasłą są różne!" scope="request"/>
            </c:if>
            <jsp:forward page="rejestracja.jsp"/>
        </c:otherwise>
    </c:choose>

</body>
</html>
