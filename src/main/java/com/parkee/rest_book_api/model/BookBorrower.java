package com.parkee.rest_book_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "book_borrower")
public class BookBorrower {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_borrower_seq")
	@SequenceGenerator(name = "book_borrower_seq", sequenceName = "book_borrower_seq", initialValue = 1, allocationSize=1)
	private int id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "isbn", referencedColumnName = "isbn")
	private Book book;
	
	@OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "ktp", referencedColumnName = "ktp")
	private Borrower borrower;
	
	private String is_returned;
	
	private String borrow_dt;
	
	private String returned_dt;
	
	private String deadline_dt;
	
	public BookBorrower() {
		
	}
	
	public BookBorrower(int id, Book book, Borrower borrower, String is_returned, String borrow_dt,
			String returned_dt, String deadline_dt) {
		super();
		this.id = id;
		this.book = book;
		this.borrower = borrower;
		this.is_returned = is_returned;
		this.borrow_dt = borrow_dt;
		this.returned_dt = returned_dt;
		this.deadline_dt = deadline_dt;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Borrower getBorrower() {
		return borrower;
	}

	public void setBorrower(Borrower borrower) {
		this.borrower = borrower;
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
