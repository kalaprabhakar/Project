package com.kuu.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.kuu.dao.CustomerDAO;
import com.kuu.factories.ConnectionFactories;
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id  =  Integer.parseInt(request.getParameter("id"));
		
		CustomerDAO dao = new CustomerDAO(ConnectionFactories.getConnection());
		boolean f = dao.deleteCustomer(id);
		
		HttpSession session = request.getSession();
		
		if(f) {
			session.setAttribute("succMsg", "200, Successfully deleted");
			response.sendRedirect("index.jsp");
			
		}else {
			session.setAttribute("errorMsg", "500, Error Not deleted");
			response.sendRedirect("index.jsp");
			
		}
		
	}

}
