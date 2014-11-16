<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv='Content-Type' content='text/html; charset=utf-8'>
    <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css'>
    <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css'>
    <script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js'></script>
    <title>Strona logowania</title>
</head>
<body>
    <c:if test="${sessionScope['username'] != null}">
        <c:redirect url="index"/>
    </c:if>
    <div class="container">
        <form role="form" action="loguj.jsp" method="POST">

            <div class="form-group ${requestScope['username'] != null ? "has-error" : ""}">
                <label for="login">Login</label>
                <input type="text" class="form-control" name="login" id="login"
                       placeholder="Wprowadź login" required>
                <span class="help-block">${requestScope['username']}</span>
            </div>
            <div class="form-group ${requestScope['password'] != null ? "has-error" : ""}">
                <label for="password">Password</label>
                <input type="password" class="form-control" name="password" id="password" placeholder="Hasło" required>
                <span class="help-block">${requestScope['password']}</span>
            </div>
            <button type="submit" class="btn btn-default">Submit</button>
        </form>
        <span>Nie masz konta? <a href="rejestracja.jsp">Zarejestruj się.</a></span>
    </div>
</body>
</html>
