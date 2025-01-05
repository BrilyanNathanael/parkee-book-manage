package com.parkee.rest_book_api.service;

import java.util.List;

import com.parkee.rest_book_api.model.Borrower;

public interface BorrowerService {
	public List<Borrower> getAllBorrower();
	public Borrower findByKtp(String ktp);
	public void addBorrower(Borrower borrower);
	public void updateBorrower(Borrower book);
	public void deleteByKtp(String ktp);
}
