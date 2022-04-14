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



@WebServlet("/addcustomer")
public class AddCustomer extends HttpServlet  {
	
	private static final long serialVersionUID = 1L;
	private CustomerDAO CustomerDAO;
	
	public void init() {
		CustomerDAO = new CustomerDAO();
	}

    public AddCustomer() {
        super();
    }
   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
	
			
			insertCustomerObj(request, response);
		} catch (SQLException | IOException e) {
			
			e.printStackTrace();
		}
	}
	
	private void insertCustomerObj(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
	
		
		String business_code = request.getParameter("business_code");
		String business_name  = request.getParameter("business_name");
		String cust_number = request.getParameter("cust_number");
		String name_customer = request.getParameter("name_customer");
		String clear_date = request.getParameter("clear_date");
		String buisness_year = request.getParameter("buisness_year");
		String doc_id = request.getParameter("doc_id");
		String posting_date  = request.getParameter("posting_date");
		String document_create_date = request.getParameter("document_create_date");
		String document_create_date1 = request.getParameter("document_create_date1");
		String due_in_date  = request.getParameter("due_in_date");
		String invoice_currency = request.getParameter("invoice_currency");
		String document_type  = request.getParameter("document_type");
		String posting_id = request.getParameter("posting_id");
		String area_business = request.getParameter("area_business");
		String total_open_amount = request.getParameter("total_open_amount");
		String baseline_create_date = request.getParameter("baseline_create_date");
		String cust_payment_terms = request.getParameter("cust_payment_terms");
		String invoice_id  = request.getParameter("invoice_id");
		String isOpen = request.getParameter("isOpen");
		String predicted = request.getParameter("predicted");		
		
		Customer newCustomer = new Customer(business_code,business_name,cust_number,name_customer,clear_date,buisness_year,doc_id,
				posting_date,document_create_date,document_create_date1,due_in_date,
				invoice_currency,document_type,posting_id,area_business,total_open_amount,baseline_create_date,
				cust_payment_terms,invoice_id,isOpen,predicted);
		
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Origin", "*");
	    response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
	    response.setHeader("Access-Control-Max-Age", "3600");
	    response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
	    
	    
	    if(CustomerDAO.insertCustomer(newCustomer) == true) {
	    PrintWriter out = response.getWriter();
		String str = "{\"success\":\"true\",\"message\":\"Customer added successfully\"}";
		out.print(str);
	    }
	    
	    else {
	    	
	    	PrintWriter out = response.getWriter();
			String str = "{\"success\":\"false\",\"message\":\"Something went wrong\"}";
			out.print(str);

	    }
		
	}

}
