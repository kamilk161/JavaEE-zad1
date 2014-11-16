<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv='Content-Type' content='text/html; charset=utf-8'>
    <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css'>
    <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css'>
    <script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js'></script>
    <title>Strona rejestracji</title>
</head>
<body>
    <jsp:useBean id="user" class="pl.kkrampa.lab1.domain.User" scope="session" />

    <div class="container">
        <c:out value="${error}"/>
        <form role="form" action="dodajUsera.jsp" method="POST">
            <div class="form-group">
                <label for="login">Login</label>
                <input type="text" class="form-control"
                       name="login" id="login" placeholder="Wprowadź login" value="${user.login}">
            </div>
            <div class="form-group">
                <label for="password">Hasło</label>
                <input type="password" class="form-control"
                       name="password" id="password" placeholder="Hasło"/>
            </div>

            <div class="form-group">
                <label for="rpassword">Powtórz hasło</label>
                <input type="password" class="form-control" name="rpassword" id="rpassword" placeholder="Powtórz hasło">
            </div>
            <button type="submit" class="btn btn-default">Zarejestruj się</button>
        </form>
    </div>
</body>
</html>
