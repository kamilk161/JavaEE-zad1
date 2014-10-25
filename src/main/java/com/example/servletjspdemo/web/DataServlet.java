package com.example.servletjspdemo.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.kkrampa.lab1.domain.Dzien;
import pl.kkrampa.lab1.domain.Pogoda;

@WebServlet(urlPatterns = "/data")
public class DataServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		if(request.getParameter("data").equals("") || 
				request.getParameter("imieniny").equals("") || 
				request.getParameter("pogoda").equals("")) {
			response.sendRedirect("form");
		}
		
		PrintWriter out = response.getWriter();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = dateFormat.parse(request.getParameter("data"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Integer p = new Integer(request.getParameter("pogoda"));
		String imieniny = request.getParameter("imieniny");
		Dzien dzien = new Dzien(date, Pogoda.fromInteger(p), imieniny);
		out.println("<html><body>" +
				"<p>Data: " + dzien.getData() + "</p>" +
				"<p>Imieniny: " + dzien.getImieniny() + "</p>" +
				"<p>Pogoda: " + dzien.getPogoda() + "</p>" +
				"</body></html>");
		out.close();
	}

}
