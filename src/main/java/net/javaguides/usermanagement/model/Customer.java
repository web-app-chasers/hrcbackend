package net.javaguides.usermanagement.model;

public class Customer {
	protected int sl_no;
	protected String business_code;
	protected String business_name;
	protected String cust_number;
	protected String name_customer;
	protected String clear_date;
	protected String buisness_year;
	protected String doc_id;
	protected String posting_date;
	protected String document_create_date;
	protected String document_create_date1;
	protected String due_in_date;
	protected String invoice_currency;
	protected String document_type;
	protected String posting_id;
	protected String area_business;
	protected String total_open_amount;
	protected String baseline_create_date;
	protected String cust_payment_terms;
	protected String invoice_id;
	protected String isOpen;
	protected String predicted;
	
	public Customer(String business_code,String business_name,String cust_number,String name_customer,String clear_date,
			String buisness_year,
			String doc_id,
			String posting_date,String document_create_date,String document_create_date1,String due_in_date, String invoice_currency,
			String document_type,
			String posting_id,
			String area_business, String total_open_amount, String baseline_create_date , String cust_payment_terms,String invoice_id,
			String isOpen,
			String predicted) {
		super();
		this.business_code = business_code;
		this.business_name = business_name;
		this.cust_number = cust_number;
		this.name_customer = name_customer;
		this.clear_date = clear_date;
		this.doc_id = doc_id;
		this.buisness_year = buisness_year;
		this.posting_date = posting_date;
		this.document_create_date = document_create_date;
		this.document_create_date1 = document_create_date1;
		this.due_in_date = due_in_date;
		this.invoice_currency = invoice_currency;
		this.posting_id = posting_id;
		this.area_business = area_business;
		this.total_open_amount = total_open_amount;
		this.baseline_create_date = baseline_create_date;
		this.cust_payment_terms = cust_payment_terms;
		this.invoice_id = invoice_id;
		this.document_type = document_type;
		this.isOpen = isOpen;
		this.predicted = predicted;	
	}
	
	public Customer(int sl_no,String business_code,String business_name,String cust_number,String name_customer,String clear_date,
			String buisness_year,
			String doc_id,
			String posting_date,String document_create_date,String document_create_date1,String due_in_date, String invoice_currency,
			String document_type,
			String posting_id,
			String area_business, String total_open_amount, String baseline_create_date , String cust_payment_terms,String invoice_id,
			String isOpen,
			String predicted) {
		super();
		this.sl_no = sl_no; 
		this.business_code = business_code;
		this.business_name = business_name;
		this.cust_number = cust_number;
		this.name_customer = name_customer;
		this.clear_date = clear_date;
		this.doc_id = doc_id;
		this.buisness_year = buisness_year;
		this.posting_date = posting_date;
		this.document_create_date = document_create_date;
		this.document_create_date1 = document_create_date1;
		this.due_in_date = due_in_date;
		this.invoice_currency = invoice_currency;
		this.posting_id = posting_id;
		this.area_business = area_business;
		this.total_open_amount = total_open_amount;
		this.baseline_create_date = baseline_create_date;
		this.cust_payment_terms = cust_payment_terms;
		this.invoice_id = invoice_id;
		this.document_type = document_type;
		this.isOpen = isOpen;
		this.predicted = predicted;	
	}
	
	
	
	public Customer(int sl_no,String invoice_currency,String cust_payment_terms) {
		super();
		this.sl_no = sl_no;
		this.invoice_currency = invoice_currency;
		this.cust_payment_terms = cust_payment_terms;
	}
	
	public int getSl_no() {
		return sl_no;
	}
	public void setSl_no(int sl_no) {
		this.sl_no = sl_no;
	}
	
	public String getBusiness_code() {
		return business_code;
	}
	public void setBusiness_code(String business_code) {
		this.business_code = business_code;
	}
	
	
	public String getBusiness_name() {
		return business_name;
	}
	
	public void setBusiness_name(String business_name) {
		this.business_name = business_name;
	}
	
	
	public String getCust_number() {
		return cust_number;
	}

	public void setCust_numbere(String cust_number) {
		this.cust_number = cust_number;
	}
	
	
	public String getName_customer() {
		return name_customer;
	}
	public void setName_customer(String name_customer) {
		this.name_customer = name_customer;
	}
	
	public String getClear_date() {
		return clear_date;
	}
	
	public void setClear_date(String clear_date) {
		this.clear_date = clear_date;
	}
	
	public String getBuisness_year() {
		return buisness_year;
	}
	public void setBuisness_year(String buisness_year) {
		this.buisness_year = buisness_year;
	}
	
	
	
	public String getDoc_id() {
		return doc_id;
	}
	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}
	
	
	public String getPosting_date() {
		return posting_date;
	}
	public void setPosting_date(String posting_date) {
		this.posting_date = posting_date;
	}
	
	
	public String getDocument_create_date() {
		return document_create_date;
	}
	public void setDocument_create_date(String document_create_date) {
		this.document_create_date = document_create_date;
	}
	

	public String getDocument_create_date1() {
		return document_create_date1;
	}
	public void setDocument_create_date1(String document_create_date1) {
		this.document_create_date1 = document_create_date1;
	}
	
	public String getDue_in_date() {
		return due_in_date;
	}
	public void setDue_in_date(String due_in_date) {
		this.due_in_date = due_in_date;
	}
	
	
	public String getInvoice_currency() {
		return invoice_currency;
	}
	public void setInvoice_currency(String invoice_currency) {
		this.invoice_currency = invoice_currency;
	}
	
	
	public String getPosting_id() {
		return posting_id;
	}
	public void setPosting_id(String posting_id) {
		this.posting_id = posting_id;
	}
	
	
	public String getArea_business() {
		return area_business;
	}
	public void setArea_business(String area_business) {
		this.area_business =area_business;
	}
	
	public String getTotal_open_amount() {
		return total_open_amount;
	}
	public void setTotal_open_amount(String total_open_amount) {
		this.total_open_amount =total_open_amount;
	}
	
	public String getBaseline_create_date() {
		return  baseline_create_date;
	}
	public void setBaseline_create_date(String  baseline_create_date) {
		this.baseline_create_date = baseline_create_date;
	}
	
	public String getCust_payment_terms() {
		return  cust_payment_terms;
	}
	public void setCust_payment_terms(String  cust_payment_terms) {
		this.cust_payment_terms = cust_payment_terms;
	}
	
	public String getInvoice_id() {
		return  invoice_id;
	}
	public void setInvoice_id(String  invoice_id) {
		this.invoice_id = invoice_id;
	}
	
	public String getDocument_type() {
		return  document_type;
	}
	public void setDocument_type(String  document_type) {
		this.document_type = document_type;
	}

	
	public String getIsOpen() {
		return  isOpen;
	}
	public void setIsOpen(String  isOpen) {
		this. isOpen = isOpen;
	}
	
	public String getPredicted() {
		return  predicted;
	}
	public void setPredicted(String  predicted) {
		this. predicted = predicted;
	}

}