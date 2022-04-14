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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/allcustomer")
public class AllCustomer extends HttpServlet  {
	
	
	private static final long serialVersionUID = 1L;
	private CustomerDAO CustomerDAO;
	
	public void init() {
		CustomerDAO = new CustomerDAO();
	}

    public AllCustomer() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			listCustomer(request,response);
		} catch (SQLException | IOException | ServletException e) {

			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
	
	private void listCustomer(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		    int page = 1;
	        int recordsPerPage = 5;
	        if (request.getParameter("page") != null)
	            page = Integer.parseInt(
	                request.getParameter("page"));
	        
	        List<Customer> listCustomer = CustomerDAO.selectAllCustomer((page - 1) * recordsPerPage,
		            recordsPerPage);
	   
	 
        int noOfRecords = 10 ;//CustomerDAO.getNoOfRecords();
        int noOfPages = (int)Math.ceil(noOfRecords * 1.0
                                       / recordsPerPage);
		
		Gson gson = new GsonBuilder().serializeNulls().create();
		String invoices  = gson.toJson(listCustomer);
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Origin", "*");
	    response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
	    response.setHeader("Access-Control-Max-Age", "3600");
	    response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		
		try {
			
		response.getWriter().write(invoices);
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
				
	}

	
   

}
