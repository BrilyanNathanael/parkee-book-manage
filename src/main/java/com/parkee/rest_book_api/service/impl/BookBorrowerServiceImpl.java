package com.parkee.rest_book_api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parkee.rest_book_api.model.BookBorrower;
import com.parkee.rest_book_api.repository.BookBorrowerRepository;
import com.parkee.rest_book_api.service.BookBorrowerService;

@Service
public class BookBorrowerServiceImpl implements BookBorrowerService {
	
	@Autowired
	BookBorrowerRepository bookBorrowerRepository;

	@Override
	public void borrowBook(BookBorrower bookBorrower) {
		// TODO Auto-generated method stub
		bookBorrowerRepository.save(bookBorrower);
	}

	@Override
	public List<BookBorrower> findByKtp(String ktp) {
		// TODO Auto-generated method stub
		return bookBorrowerRepository.findByKtp(ktp);
	}

	@Override
	public BookBorrower findByKtpAndIsbn(String ktp, String isbn) {
		// TODO Auto-generated method stub
		return bookBorrowerRepository.findByKtpAndIsbn(ktp, isbn);
	}

	@Override
	public void updateBorrowBook(BookBorrower bookBorrower) {
		// TODO Auto-generated method stub
		bookBorrowerRepository.save(bookBorrower);
	}

	@Override
	public List<BookBorrower> findAllBooksWithBorrowers() {
		// TODO Auto-generated method stub
		return bookBorrowerRepository.findAllBooksWithBorrowers();
	}

	@Override
	public List<BookBorrower> findAllBooksWithBorrowersOnTime() {
		// TODO Auto-generated method stub
		return bookBorrowerRepository.findAllBooksWithBorrowersOnTime();
	}

	@Override
	public List<BookBorrower> findAllBooksWithBorrowersOverDeadline() {
		// TODO Auto-generated method stub
		return bookBorrowerRepository.findAllBooksWithBorrowersOverDeadline();
	}
	
	

}
