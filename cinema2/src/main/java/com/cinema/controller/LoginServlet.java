package com.cinema.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cinema.dto.User;
import com.cinema.service.AutheticationService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/action-login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("usuName");
		String userPass = request.getParameter("usuPass");
		AutheticationService servei = new AutheticationService();
		boolean isAuthenticate = servei.validUser(userId, userPass);
		

		// Comprova si l'usuari existeix
		if (isAuthenticate) {
			System.out.println("usuari:"+userId); 
			
			// Afegir l'usuari a la sessió i saludar a l'usuari
			User usuari = servei.getUsuari(userId);			
			request.getSession().setAttribute("user", usuari);			
			response.sendRedirect("login/user-greeting.jsp");
			
		}else {
			response.sendRedirect("login/user-login.jsp");
		}

	}

}
