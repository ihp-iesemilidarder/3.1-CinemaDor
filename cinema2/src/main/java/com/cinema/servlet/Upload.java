package com.cinema.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name = "Upload", urlPatterns = {"/upload-file"})
//@MultipartConfig(location = "/tmp")
@MultipartConfig(
	location = "C:\\Users\\hp-01\\tmp",
	maxFileSize = 10*1024*1024
)

public class Upload extends HttpServlet {
	//info: https://javaee.github.io/tutorial/servlets011.html
	private static final long serialVersionUID = -6238570975300484827L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		try (PrintWriter out = response.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet CarregaFitxerServlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Càrrega de Fitxers</h1>");
			Part p = request.getPart("fitxer");
			p.write(p.getSubmittedFileName());
			out.println("<p>S'ha pujat el fitxer.</p>");
			out.println("</body>");
			out.println("</html>");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}
}
