package net.javaguides.usermanagement.dao;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.javaguides.usermanagement.model.Customer;
import net.javaguides.usermanagement.model.User;

public class CustomerDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/demo";
	private String username = "root";
	private String password = "";
	
	private static final String INSERT_SQL_CUSTOMER = "INSERT INTO customer" + "(`business_code`, `business_name`, `cust_number`, "
			+ "`name_customer`, `clear_date`, "+ "`buisness_year`, `doc_id`, `posting_date`, `document_create_date`,"
			+ " `document_create_date1`, `due_in_date`, `invoice_currency`, "
			+ "`document_type`, `posting_id`, `area_business`, `total_open_amount`, "
			+ "`baseline_create_date`, `cust_payment_terms`, `invoice_id`, `isOpen`, `predicted`) "
			+ "VALUES" 
			+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
	
	
     private static final String SELECT_ALL_CUSTOMER = "SELECT * from customer;";
	 private static final String DELETE_CUSTOMER_SQL = "delete from customer where sl_no = ?;";
	 private static final String UPDATE_CUSTOMER_SQL = "update customer set invoice_currency = ?,cust_payment_terms = ? where sl_no = ? ;"; 
	 private static final String ADVANCE_SEARCH_SQL = "SELECT * from customer doc_id LIKE ? OR cust_number LIKE ? OR invoice_id LIKE ? OR buisness_year LIKE ? ;";
	
	
	protected  Connection getConnection() {
		Connection connection = null;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL,username,password);
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;	
	}
	
	private String printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
				
				return e.getMessage();
			}
		}
		return null;
		
	}
	
	
	
	public boolean insertCustomer(Customer customer) throws SQLException{
		System.out.println(INSERT_SQL_CUSTOMER);
		
		try(Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL_CUSTOMER)){
			
			preparedStatement.setString(1, customer.getBusiness_code());
			preparedStatement.setString(2, customer.getBusiness_name());
			preparedStatement.setString(3, customer.getCust_number());
			preparedStatement.setString(4, customer.getName_customer());
			preparedStatement.setString(5, customer.getClear_date());
			preparedStatement.setString(6, customer.getBuisness_year());
			preparedStatement.setString(7, customer.getDoc_id());
			preparedStatement.setString(8, customer.getPosting_date());
			preparedStatement.setString(9, customer.getDocument_create_date());
			preparedStatement.setString(10, customer.getDocument_create_date1());
			preparedStatement.setString(11, customer.getDue_in_date());
			preparedStatement.setString(12, customer.getInvoice_currency());
			preparedStatement.setString(13, customer.getDocument_type());
			preparedStatement.setString(14, customer.getPosting_id());
			preparedStatement.setString(15, customer.getArea_business());
			preparedStatement.setString(16, customer.getTotal_open_amount());
			preparedStatement.setString(17, customer.getBaseline_create_date());
			preparedStatement.setString(18, customer.getCust_payment_terms());
			preparedStatement.setString(19, customer.getInvoice_id());
			preparedStatement.setString(20, customer.getIsOpen());
			preparedStatement.setString(21, customer.getPredicted());
			
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			printSQLException(e);
			return false;
		}
	}

	
	
	public List<Customer> selectAllCustomer(int offset , int noOfRecords){
		List<Customer> customer = new ArrayList<>();
		String Paginate_query = "SELECT * from customer limit " + offset + ", " + noOfRecords ;
		try(Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(Paginate_query);){
				System.out.println(preparedStatement);
				ResultSet rs = preparedStatement.executeQuery();
				
	
				while (rs.next()) {
					int id = rs.getInt("sl_no");
					
					String business_code = rs.getString("business_code");
		
					String business_name = rs.getString("business_name");
					String cust_number = rs.getString("cust_number");
					String name_customer = rs.getString("name_customer");
					String clear_date = rs.getString("clear_date");
					String buisness_year = rs.getString("buisness_year");
					String doc_id = rs.getString("doc_id");
					String posting_date = rs.getString("posting_date");
					String document_create_date = rs.getString("document_create_date");
					String document_create_date1 = rs.getString("document_create_date1");
					String due_in_date = rs.getString("due_in_date");
					String invoice_currency = rs.getString("invoice_currency");
					String document_type = rs.getString("document_type");
					String posting_id = rs.getString("posting_id");
					String area_business = rs.getString("area_business");
					String total_open_amount = rs.getString("total_open_amount");
					String baseline_create_date = rs.getString("baseline_create_date");
					String cust_payment_terms = rs.getString("cust_payment_terms");
					String invoice_id = rs.getString("invoice_id");
					String isOpen = rs.getString("isOpen");
					String predicted = rs.getString("predicted");
		

					customer.add(new Customer(id, business_code,business_name,cust_number,name_customer,clear_date,buisness_year,doc_id,
							posting_date,document_create_date,document_create_date1,due_in_date,
							invoice_currency,document_type,posting_id,area_business,total_open_amount,baseline_create_date,
							cust_payment_terms,invoice_id,isOpen,predicted));
				}
		}
		
		catch(SQLException e) {
			printSQLException(e);
		
	}

		return customer;
		
	}
	
	
	public boolean deleteCustomer(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMER_SQL);) {
			    statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		
		return rowDeleted;
	}
	
	public boolean updateCustomer(Customer customer) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_CUSTOMER_SQL);) {
			statement.setString(1, customer.getInvoice_currency());
			statement.setString(2, customer.getCust_payment_terms());
			statement.setInt(3, customer.getSl_no());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	
	public List<Customer> selectAllSearchedCustomer(int offset , int noOfRecords,HttpServletRequest request){
		List<Customer> customer = new ArrayList<>();
		String Paginate_query = "SELECT * from customer where doc_id LIKE ? OR cust_number LIKE ? OR invoice_id LIKE ? OR buisness_year LIKE ? limit " + offset + ", " + noOfRecords ;
		System.out.println(Paginate_query);
	try(Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(Paginate_query)){
	
		String doc = request.getParameter("doc_id");
		String cust = request.getParameter("cust_number");
		String invoice = request.getParameter("invoice_id");
		String buisness = request.getParameter("buisness_year");
		
		/*
		String doc = "%"+request.getParameter("doc_id")+"%";
		String cust = "%"+request.getParameter("cust_number")+"%";
		String invoice = "%"+request.getParameter("invoice_id")+"%";
		String buisness = "%"+request.getParameter("buisness_year")+"%";*/
		
		preparedStatement.setString(1,doc);
		preparedStatement.setString(2,cust);
		preparedStatement.setString(3,invoice);
		preparedStatement.setString(4,buisness);
		
		System.out.println(preparedStatement);
				
		ResultSet rs = preparedStatement.executeQuery();
		

		while (rs.next()) {
			int id = rs.getInt("sl_no");
			
			String business_code = rs.getString("business_code");
			System.out.println(business_code);

			String business_name = rs.getString("business_name");
			String cust_number = rs.getString("cust_number");
			String name_customer = rs.getString("name_customer");
			String clear_date = rs.getString("clear_date");
			String buisness_year = rs.getString("buisness_year");
			String doc_id = rs.getString("doc_id");
			String posting_date = rs.getString("posting_date");
			String document_create_date = rs.getString("document_create_date");
			String document_create_date1 = rs.getString("document_create_date1");
			String due_in_date = rs.getString("due_in_date");
			String invoice_currency = rs.getString("invoice_currency");
			String document_type = rs.getString("document_type");
			String posting_id = rs.getString("posting_id");
			String area_business = rs.getString("area_business");
			String total_open_amount = rs.getString("total_open_amount");
			String baseline_create_date = rs.getString("baseline_create_date");
			String cust_payment_terms = rs.getString("cust_payment_terms");
			String invoice_id = rs.getString("invoice_id");
			String isOpen = rs.getString("isOpen");
			String predicted = rs.getString("predicted");


			customer.add(new Customer(id, business_code,business_name,cust_number,name_customer,clear_date,buisness_year,doc_id,
					posting_date,document_create_date,document_create_date1,due_in_date,
					invoice_currency,document_type,posting_id,area_business,total_open_amount,baseline_create_date,
					cust_payment_terms,invoice_id,isOpen,predicted));
		}
}
		
		catch(SQLException e) {
			printSQLException(e);
		
	}

		return customer;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
