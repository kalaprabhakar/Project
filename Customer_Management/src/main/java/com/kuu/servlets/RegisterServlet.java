package com.kuu.servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.kuu.dao.CustomerDAO;
import com.kuu.entities.Customer;
import com.kuu.factories.ConnectionFactories;

import jakarta.servlet.annotation.WebServlet;
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
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
		
		Customer customer = new Customer(first_name, last_name, street, address, city, state, email, phone);
		
		CustomerDAO customerDAO = new CustomerDAO(ConnectionFactories.getConnection());
		
		HttpSession session  = request.getSession();
		boolean f =customerDAO.addCustomer(customer);
		
		
		if(f) {
			session.setAttribute("succMsg", "Success: 201, Successfully Created");
			response.sendRedirect("add_customer.jsp");
			
		}else {
			session.setAttribute("errorMsg", "Failure: 400, First Name or Last Name is missing");
			response.sendRedirect("add_customer.jsp");
			
		}
		
		
	}

}
