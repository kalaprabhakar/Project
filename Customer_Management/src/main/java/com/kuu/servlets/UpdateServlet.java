package com.kuu.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.kuu.dao.CustomerDAO;
import com.kuu.entities.Customer;
import com.kuu.factories.ConnectionFactories;
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String street = request.getParameter("street");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		int id = Integer.parseInt(request.getParameter("id"));
		
		Customer customer = new Customer(id,first_name, last_name, street, address, city, state, email, phone);
		
		CustomerDAO customerDAO = new CustomerDAO(ConnectionFactories.getConnection());
		
		HttpSession session  = request.getSession();
		
		boolean f = customerDAO.updateCustomer(customer);
		

		if(f) {
			session.setAttribute("succMsg", "200, Successfully Updated");
			response.sendRedirect("index.jsp");
			
		}else {
			session.setAttribute("errorMsg", "400, Body is Empty");
			response.sendRedirect("index.jsp");
			
		}
	}

}
