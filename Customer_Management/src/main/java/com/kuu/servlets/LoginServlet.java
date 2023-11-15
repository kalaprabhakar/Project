package com.kuu.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ename = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		
		RequestDispatcher dispatcher = null;
		if(ename.equals("prabhakar") && upwd.equals("prabhakar")) {
			dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}else {
			dispatcher = request.getRequestDispatcher("failure.html");
			dispatcher.forward(request, response);
		}
	}

}
