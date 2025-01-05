package com.parkee.rest_book_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parkee.rest_book_api.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{
	Book findByIsbn(String isbn);
	void deleteByIsbn(String isbn);
}
