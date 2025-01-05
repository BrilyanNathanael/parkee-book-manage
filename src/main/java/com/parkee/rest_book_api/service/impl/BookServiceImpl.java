package com.parkee.rest_book_api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parkee.rest_book_api.model.Book;
import com.parkee.rest_book_api.repository.BookRepository;
import com.parkee.rest_book_api.service.BookService;

import jakarta.transaction.Transactional;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookRepository bookRepository;

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return bookRepository.findAll();
	}

	@Override
	public Book findByIsbn(String isbn) {
		// TODO Auto-generated method stub
		return bookRepository.findByIsbn(isbn);
	}

	@Override
	public void addBook(Book book) {
		// TODO Auto-generated method stub
		bookRepository.save(book);
	}

	@Override
	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		bookRepository.save(book);
	}

	@Override
	@Transactional
	public void deleteByIsbn(String isbn) {
		// TODO Auto-generated method stub
		bookRepository.deleteByIsbn(isbn);
	}

}
