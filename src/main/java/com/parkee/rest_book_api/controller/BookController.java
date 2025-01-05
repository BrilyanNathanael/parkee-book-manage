package com.parkee.rest_book_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parkee.rest_book_api.model.Book;
import com.parkee.rest_book_api.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}
	
	@PostMapping
	public String addBook(@RequestBody Book book) {
		bookService.addBook(book);
		return "Success Add Product!";
	}
	
	@PutMapping("/{isbn}")
	public String updateBook(@PathVariable String isbn, @RequestBody Book book) {
		Book b = bookService.findByIsbn(isbn);
		
		b.setStock(book.getStock());
		b.setTitle(book.getTitle());
		
		bookService.updateBook(b);
		return "Success Update Product!";
	}
	
	@DeleteMapping("/{isbn}")
	public String deleteBook(@PathVariable String isbn) {
		bookService.deleteByIsbn(isbn);
		return "Success Delete Product!";
	}
	
}
