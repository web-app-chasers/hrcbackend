package net.javaguides.usermanagement.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.io.PrintWriter;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.usermanagement.dao.CustomerDAO;
import net.javaguides.usermanagement.model.Customer;


@WebServlet("/updatecustomer")
public class UpdateCustomer extends HttpServlet  {
	
	private static final long serialVersionUID = 1L;
	private CustomerDAO CustomerDAO;
	
	public void init() {
		CustomerDAO = new CustomerDAO();
	}

    public UpdateCustomer() {
        super();
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	try {	
		updateCustomer(request,response);	
		}
		
		catch(Exception e) {
		
			
		}
}
	
	
	private void updateCustomer(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		//System.out.println(id);
		
		String invoice_currency = request.getParameter("invoice_currency");
		String cust_payment_terms  = request.getParameter("cust_payment_terms");
		
		Customer customer_update = new Customer(id, invoice_currency , cust_payment_terms);
		
		CustomerDAO.updateCustomer(customer_update);
		
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Origin", "*");
	    response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
	    response.setHeader("Access-Control-Max-Age", "3600");
	    response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
	    
		String str = "{\"success\":\"true\",\"message\":\"Customer updated successfully\"}";
		out.print(str);
		
		
		//response.sendRedirect("list");
	}

}
