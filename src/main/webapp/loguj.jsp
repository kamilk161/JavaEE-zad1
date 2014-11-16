<%@ page import="pl.kkrampa.lab1.domain.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:useBean id="users" class="pl.kkrampa.lab1.service.UserService" scope="application" />


<%
    User user = users.findByLogin(request.getParameter("login"));
    if(user == null) {
        request.setAttribute("username", "Niepoprawny login");
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
    else if(!user.getPassword().equals(request.getParameter("password"))) {
        request.setAttribute("password", "Niepoprawne hasło");
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    } else {
        session.setAttribute("username", user.getLogin());
        response.sendRedirect("index");
    }
%>