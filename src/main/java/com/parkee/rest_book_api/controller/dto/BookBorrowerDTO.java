package com.parkee.rest_book_api.controller.dto;


public class BookBorrowerDTO {

	private String ktp;
	
	private String name;
	
	private String email;
	
	private String isbn;
	
	private String is_returned;
	
	private String borrow_dt;
	
	private String returned_dt;
	
	private String deadline_dt;
	
	public String getKtp() {
		return ktp;
	}

	public void setKtp(String ktp) {
		this.ktp = ktp;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getIs_returned() {
		return is_returned;
	}

	public void setIs_returned(String is_returned) {
		this.is_returned = is_returned;
	}

	public String getBorrow_dt() {
		return borrow_dt;
	}

	public void setBorrow_dt(String borrow_dt) {
		this.borrow_dt = borrow_dt;
	}

	public String getReturned_dt() {
		return returned_dt;
	}

	public void setReturned_dt(String returned_dt) {
		this.returned_dt = returned_dt;
	}
	
	public String getDeadline_dt() {
		return deadline_dt;
	}

	public void setDeadline_dt(String deadline_dt) {
		this.deadline_dt = deadline_dt;
	}
	
}
