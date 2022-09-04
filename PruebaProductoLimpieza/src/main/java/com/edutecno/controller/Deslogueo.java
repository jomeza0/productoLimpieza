package com.edutecno.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Deslogueo
 * Invalidar sesion y despachar al index.jsp
 */
@WebServlet("/logout")
public class Deslogueo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.getCookies();
		
		session.invalidate();
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}// fin doGet

}//fin class
