package com.parkee.rest_book_api.service;

import java.util.List;

import com.parkee.rest_book_api.model.BookBorrower;

public interface BookBorrowerService {
	public BookBorrower findByBorrower_Ktp(String ktp);
	public BookBorrower findByKtpAndIsbn(String ktp, String isbn);
	public List<BookBorrower> findAllBooksWithBorrowers();
	public List<BookBorrower> findAllBooksWithBorrowersOnTime();
	public List<BookBorrower> findAllBooksWithBorrowersOverDeadline();
	public void borrowBook(BookBorrower bookBorrower);
	public void updateBorrowBook(BookBorrower bookBorrower);
}
