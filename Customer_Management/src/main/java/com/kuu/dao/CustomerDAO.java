package com.kuu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.kuu.entities.Customer;

public class CustomerDAO {

	
	private Connection connection;

	public CustomerDAO(Connection connection) {
		super();
		this.connection = connection;
	}
	
	public boolean addCustomer(Customer customer) {
		
		boolean f = false;
		
		try {
			
			String sql = "insert into customer(first_name,last_name,street,address,city,state,email,phone) values(?,?,?,?,?,?,?,?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, customer.getFirst_name());
			preparedStatement.setString(2, customer.getLast_name());
			preparedStatement.setString(3, customer.getStreet());
			preparedStatement.setString(4, customer.getAddress());
			preparedStatement.setString(5, customer.getCity());
			preparedStatement.setString(6, customer.getState());
			preparedStatement.setString(7, customer.getEmail());
			preparedStatement.setString(8, customer.getPhone());
			
			int i = preparedStatement.executeUpdate();
			
			if(i==1) {
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return f;
	}
	
	
	public List<Customer> getAllCustomer(){
		List<Customer> list  = new ArrayList<Customer>();
		Customer c =null;
		
		try {
			String sql = "select * from customer";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				c = new Customer();
				c.setId(rs.getInt(1));
				c.setFirst_name(rs.getString(2));
				c.setLast_name(rs.getString(3));
				c.setStreet(rs.getString(4));
				c.setAddress(rs.getString(5));
				c.setCity(rs.getString(6));
				c.setState(rs.getString(7));
				c.setEmail(rs.getString(8));
				c.setPhone(rs.getString(9));
				list.add(c);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
 	}
	
	public Customer getCustomerById(int id) {
		 Customer c = null;
		 try {
				String sql = "select * from customer where id = ?";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, id);
				ResultSet rs = preparedStatement.executeQuery();
				
				while(rs.next()) {
					c = new Customer();
					c.setId(rs.getInt(1));
					c.setFirst_name(rs.getString(2));
					c.setLast_name(rs.getString(3));
					c.setStreet(rs.getString(4));
					c.setAddress(rs.getString(5));
					c.setCity(rs.getString(6));
					c.setState(rs.getString(7));
					c.setEmail(rs.getString(8));
					c.setPhone(rs.getString(9));
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		 
		 return c;
	}
	
public boolean updateCustomer(Customer customer) {
		
		boolean f = false;
		
		try {
			
			String sql = "update customer set first_name=?,last_name=?,street=?,address=?,city=?,state=?,email=?,phone=? where id = ?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, customer.getFirst_name());
			preparedStatement.setString(2, customer.getLast_name());
			preparedStatement.setString(3, customer.getStreet());
			preparedStatement.setString(4, customer.getAddress());
			preparedStatement.setString(5, customer.getCity());
			preparedStatement.setString(6, customer.getState());
			preparedStatement.setString(7, customer.getEmail());
			preparedStatement.setString(8, customer.getPhone());
			preparedStatement.setInt(9, customer.getId());
			
			int i = preparedStatement.executeUpdate();
			
			if(i==1) {
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return f;
	}

  public boolean deleteCustomer(int id) {
	  boolean f= false;
	  
	  try {
		  String sql = "delete from customer where id = ?";
		  PreparedStatement preparedStatement = connection.prepareStatement(sql);
		  preparedStatement.setInt(1, id);
		  

			int i = preparedStatement.executeUpdate();
			
			if(i==1) {
				f=true;
			}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	  return f;
  }
	
	
}
