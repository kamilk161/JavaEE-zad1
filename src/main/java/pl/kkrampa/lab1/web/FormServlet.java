package pl.kkrampa.lab1.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/index")
public class FormServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("username") == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        String username = (String)session.getAttribute("username");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
        List<String> params = new ArrayList<String>();
        if(request.getParameterMap().containsKey("errors[]")) {
            params = Arrays.asList(request.getParameterValues("errors[]"));
        }

        String dataValue = "";
        if(request.getParameterMap().containsKey("data")) {
            dataValue = request.getParameter("data");
        }

        String imieninyValue = "";
        if(request.getParameterMap().containsKey("imieniny")) {
            imieninyValue = request.getParameter("imieniny");
        }

		out.println("<html>" +
				"<head>" +
				"<meta http-equiv='Content-Type' content='text/html; charset=utf-8'>" +
				"<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css'>" +
				"<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css'>" +
				"<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js'></script>" +
                "<title>Form servlet</title>" +
                "</head>" +
				"<body>" +
				"<div class='container'>" +
                "<span>Witaj, " + username + "! <a href='wyloguj.jsp'>Wyloguj się.</a></span>" +
				"<h2>Lab1</h2>" +
				"<form class=\"form-horizontal\" action='data' method='POST'>" +
                "<div class='form-group " + (params.contains("data") ? "has-error" : "") + "'>" +
                "<label class=\"control-label\" for=\"inputWarning\">Data: </label>" +
                "<input class=\"form-control\" type='date' name='data' value='" + dataValue + "'>" +
                "<span class=\"help-block\">Ten element jest wymagany.</span>" +
				"</div>" +
				"<div class='form-group'>" +
                "<label class=\"control-label\" for=\"inputWarning\">Pogoda: </label>" +
				"<select class=\"form-control\" name='pogoda'>" +
				"<option value='1'>Słoneczna</option>" +
				"<option value='2'>Deszczowa</option>" +
				"</select>" +
				"</div>" +
				"<div class='form-group " + (params.contains("imieniny") ? "has-error" : "") + "'>" +
                "<label class=\"control-label\" for=\"inputWarning\">Imieniny(po przecinku): </label>" +
                "<input class=\"form-control\" type='text' name='imieniny' value='" + imieninyValue + "'>" +
                "<span class=\"help-block\">Ten element jest wymagany.</span>" +
                "</div>" +
				"<input type='submit' class='btn btn-default' value='OK' />" +
				"</form>" +
				"</div></body></html>");
		out.close();
	}

}
