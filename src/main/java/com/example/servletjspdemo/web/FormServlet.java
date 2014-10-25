package com.example.servletjspdemo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/form")
public class FormServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		out.println("<html>" +
				"<head>" +
				"<meta http-equiv='Content-Type' content='text/html; charset=utf-8'>" +
				"<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css'>" +
				"<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css'>" +
				"</head>" +
				"<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js'></script>" +
				"<body>" +
				"<div class='container'>" +
				"<h2>Lab1</h2>" +
				"<form action='data' method='POST'>" +
				"<div class='form-group'>" +
				"Data: <input type='date' name='data'>" +
				"</div>" +
				"<div class='form-group'>" +
				"Pogoda: <select name='pogoda'>" +
				"<option value='1'>Słoneczna</option>" +
				"<option value='2'>Deszczowa</option>" +
				"</select>" +
				"</div>" +
				"<div class='form-group'>" +
				"Imieniny(po przecinku): <input type='text' name='imieniny'/>" +
				"</div>" +
				"<input type='submit' class='btn btn-default' value='OK' />" +
				"</form>" +
				"</div></body></html>");
		out.close();
	}

}
