package com.parkee.rest_book_api.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "borrower")
public class Borrower {
	@Id
	private String ktp;

	private String name;
	
	private String email;
	
    @OneToMany(mappedBy = "borrower", fetch = FetchType.LAZY)
    private List<BookBorrower> bookBorrowers;
	
	public Borrower() {
		
	}
	
	
	public Borrower(String ktp, String name, String email) {
		super();
		this.ktp = ktp;
		this.name = name;
		this.email = email;
	}
	
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
}
