<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv='Content-Type' content='text/html; charset=utf-8'>
    <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css'>
    <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css'>
    <script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js'></script>
    <title>Strona logowania</title>
</head>
<body>
    <div class="container">
        <form role="form">
            <div class="form-group">
                <label for="login">Login</label>
                <input type="text" class="form-control" id="login" placeholder="Wprowadź login">
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" class="form-control" id="password" placeholder="Hasło">
            </div>
            <button type="submit" class="btn btn-default">Submit</button>
        </form>
        <span>Nie masz konta? <a href="rejestracja.jsp">Zarejestruj się.</a></span>
    </div>
</body>
</html>
