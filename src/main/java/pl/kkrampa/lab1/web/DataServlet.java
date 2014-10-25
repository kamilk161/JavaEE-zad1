package pl.kkrampa.lab1.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
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
        response.setCharacterEncoding("utf-8");
		Boolean hasErrors = false;
        StringBuilder getParameters = new StringBuilder("?");
        if(request.getParameter("pogoda").equals("")) {
            hasErrors = true;
            getParameters.append("errors[]=pogoda&");
        }

        if(request.getParameter("data").equals("")) {
            hasErrors = true;
            getParameters.append("errors[]=data&");
        }

        if(request.getParameter("imieniny").equals("")) {
            hasErrors = true;
            getParameters.append("errors[]=imieniny&");
        }

        if(hasErrors) {
            response.sendRedirect("index" + getParameters.toString() + "data=" + request.getParameter("data")
            + "&imieniny=" + URLEncoder.encode(request.getParameter("imieniny"), "UTF-8"));
            return;
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
        Pogoda pog = Pogoda.fromInteger(p);
		Dzien dzien = new Dzien(date, pog, imieniny);

        out.println("<html>" +
                "<head>" +
                "<meta http-equiv='Content-Type' content='text/html; charset=utf-8'>" +
                "<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css'>" +
                "<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css'>" +
                "<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js'></script>" +
                "<title>Data servlet</title>" +
                "</head>" +
                "<body>" +
                "<nav class=\"navbar navbar-inverse\" role=\"navigation\">\n" +
                "    <div class=\"container-fluid\">\n" +
                "        <div class=\"navbar-header\">\n" +
                "            <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-9\">\n" +
                "                <span class=\"sr-only\">Toggle navigation</span>\n" +
                "                <span class=\"icon-bar\"></span>\n" +
                "                <span class=\"icon-bar\"></span>\n" +
                "                <span class=\"icon-bar\"></span>\n" +
                "            </button>\n" +
                "            <a class=\"navbar-brand\" href=\"index \">Powrót do strony głównej</a>\n" +
                "        </div><!-- /.navbar-collapse -->\n" +
                "    </div><!-- /.container-fluid -->\n" +
                "</nav>" +
                "<div class='container'>" +
                "<table class=\"table table-bordered\">" +
                "<thead><tr>" +
                "<th style='width: 22%'>Data</th><th style='width: 22%'>Imieniny</th><th>Pogoda</th><th>Zdjecie</th>" +
                "</tr></thead>" +
                "<tr>" +
				"<td>" + dateFormat.format(dzien.getData()) + "</td>" +
				"<td>" + dzien.getImieniny() + "</td>" +
				"<td>" + dzien.getPogoda() + "</td>" +
                "<td><img src='" +
                ((pog == Pogoda.SLONECZNA) ? "slonce.jpg" : "deszcz.jpg")
                + "' /></td>" +
                "</tr></table>" +
                "</div>" +
                "</body></html>");
		out.close();
	}

}
