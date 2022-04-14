package net.javaguides.usermanagement.web;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.usermanagement.dao.CustomerDAO;
import net.javaguides.usermanagement.model.Customer;


@WebServlet("/customer")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDAO CustomerDAO;
	
	public void init() {
		CustomerDAO = new CustomerDAO();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		

		try {
			switch (action) {
		/*	case "/new":
				showNewForm(request, response);
				break;*/
			case "/insert":
				insertUser(request, response);
				break;
			/*case "/delete":
				deleteUser(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
			default:
				listUser(request, response);
				break;*/
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
		String business_code = request.getParameter("business_code");
		String business_name  = request.getParameter("business_name");
		String cust_numbere = request.getParameter("cust_numbere");
		String name_customer = request.getParameter("name_customer");
		String clear_date = request.getParameter("clear_date");
		String doc_id = request.getParameter("doc_id");
		String posting_date  = request.getParameter("posting_date");
		String document_create_date = request.getParameter("document_create_date");
		String document_create_date1 = request.getParameter("document_create_date1");
		String due_in_date  = request.getParameter("due_in_date");
		String invoice_currency = request.getParameter("invoice_currency");
		String posting_id = request.getParameter("posting_id");
		String area_business = request.getParameter("area_business");
		String total_open_amount = request.getParameter("total_open_amount");
		String baseline_create_date = request.getParameter("baseline_create_date");
		String cust_payment_terms = request.getParameter("cust_payment_terms");
		String invoice_id  = request.getParameter("invoice_id");
		String isOpen = request.getParameter("isOpen");
		String predicted = request.getParameter("predicted");
		
		/*Customer newCustomer = new Customer(business_code,business_name,cust_numbere,name_customer,clear_date,doc_id,
				posting_date,document_create_date,document_create_date1,due_in_date,
				invoice_currency,posting_id,area_business,total_open_amount,baseline_create_date,
				cust_payment_terms,invoice_id,isOpen,predicted);
		CustomerDAO.insertCustomer(newCustomer);*/
		
		response.sendRedirect("list");
	}

	
	

}
