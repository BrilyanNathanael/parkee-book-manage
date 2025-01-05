package com.parkee.rest_book_api.service;

import java.util.List;

import com.parkee.rest_book_api.model.Book;

public interface BookService {
	public List<Book> getAllBooks();
	public Book findByIsbn(String isbn);
	public void addBook(Book book);
	public void updateBook(Book book);
	public void deleteByIsbn(String isbn);
}
