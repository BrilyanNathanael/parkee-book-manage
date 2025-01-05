package com.parkee.rest_book_api.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.parkee.rest_book_api.controller.dto.BookBorrowerDTO;
import com.parkee.rest_book_api.model.Book;
import com.parkee.rest_book_api.model.BookBorrower;
import com.parkee.rest_book_api.model.Borrower;
import com.parkee.rest_book_api.service.BookBorrowerService;
import com.parkee.rest_book_api.service.BookService;
import com.parkee.rest_book_api.service.BorrowerService;

@RestController
@RequestMapping("/book/borrow")
public class BookBorrowerController {
	@Autowired
	BookBorrowerService bookBorrowerService;
	
	@Autowired
	BorrowerService borrowerService;
	
	@Autowired
	BookService bookService;
	
	@GetMapping
	public List<BookBorrower> findAllBooksWithBorrowers() {
		return bookBorrowerService.findAllBooksWithBorrowers();
	}
	
	@GetMapping("/ontime")
	public List<BookBorrower> findAllBooksWithBorrowersOnTime() {
		return bookBorrowerService.findAllBooksWithBorrowersOnTime();
	}
	
	@GetMapping("/over")
	public List<BookBorrower> findAllBooksWithBorrowersOverDeadline() {
		return bookBorrowerService.findAllBooksWithBorrowersOverDeadline();
	}
	
	@PostMapping
	public String borrowBook(@RequestBody BookBorrowerDTO bookBorrowerDTO) {
		
		//	Validate Date
		String deadline_dt = validateDate(bookBorrowerDTO.getDeadline_dt());
		
		if(!deadline_dt.equals("Success")) {
			return deadline_dt;
		}
		
		String isbn = bookBorrowerDTO.getIsbn();
		
		Book book = bookService.findByIsbn(isbn);
		
		if(book == null) {
			return "No book found with the provided ISBN.";
		}
		else if(book.getStock() == 0) {
			return "Out of stock.";
		}
		
		BookBorrower oldBorrower = bookBorrowerService.findByBorrower_Ktp(bookBorrowerDTO.getKtp());
		
		if(oldBorrower != null && oldBorrower.getIs_returned().equals("N")) {
			return "You still have an unreturned book.";
		}
		
		String email = bookBorrowerDTO.getEmail();
		String ktp = bookBorrowerDTO.getKtp();
		String name = bookBorrowerDTO.getName();
		
		Borrower borrower = new Borrower(ktp, name, email);
		
		borrowerService.addBorrower(borrower);
		
		BookBorrower bookBorrower = new BookBorrower();
		
		LocalDate today = LocalDate.now();
		
		bookBorrower.setBook(book);
		bookBorrower.setBorrower(borrower);
		bookBorrower.setBorrow_dt(today.toString());
		bookBorrower.setIs_returned("N");
		bookBorrower.setDeadline_dt(bookBorrowerDTO.getDeadline_dt());
		
		bookBorrowerService.borrowBook(bookBorrower);
		
		book.setStock(book.getStock() - 1);
		bookService.updateBook(book);
		
		return "Success Borrow Book!";
		
	}
	
	@PutMapping
	public String returnBook(@RequestBody BookBorrowerDTO bookBorrowerDTO) {
		String isbn = bookBorrowerDTO.getIsbn();
		
		Book book = bookService.findByIsbn(isbn);
		
		if(book == null) {
			return "No book found with the provided ISBN.";
		}
		
		BookBorrower bookBorrower = bookBorrowerService.findByKtpAndIsbn(bookBorrowerDTO.getKtp(), isbn);
		
		if(bookBorrower == null) {
			return "No borrowing history found for the given ISBN and KTP that has not been returned.";
		}
		
		LocalDate today = LocalDate.now();
		
		bookBorrower.setReturned_dt(today.toString());
		bookBorrower.setIs_returned("Y");
		
		bookBorrowerService.updateBorrowBook(bookBorrower);
		
		book.setStock(book.getStock() + 1);
		bookService.updateBook(book);
		
		return "Success Return Book!";
		
	}
	
    public String validateDate(String date) {
        // Define the expected date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            // Attempt to parse the date
            LocalDate parsedDate = LocalDate.parse(date, formatter);
            
            LocalDate today = LocalDate.now();
            
            // Validate the date is not in the past
            if (parsedDate.isBefore(today)) {
                return "Invalid date: Date cannot be earlier than today (" + today + ").";
            }

            // Validate the date is not more than 30 days from today
            LocalDate maxDate = today.plusDays(30);
            if (parsedDate.isAfter(maxDate)) {
                return "Invalid date: Date cannot be more than 30 days from today (" + maxDate + ").";
            }
            
            return "Success";
        } catch (DateTimeParseException e) {
            // If parsing fails, return an error
            return "Invalid date format. Please use yyyy-MM-dd.";
        }
    }
	
//	@PutMapping("/{isbn}")
//	public String updateBook(@PathVariable String isbn, @RequestBody Book book) {
//		Book b = bookService.findByIsbn(isbn);
//		
//		b.setStock(book.getStock());
//		b.setTitle(book.getTitle());
//		
//		bookService.updateBook(b);
//		return "Success Update Product!";
//	}
//	
//	@DeleteMapping("/{isbn}")
//	public String deleteBook(@PathVariable String isbn) {
//		bookService.deleteByIsbn(isbn);
//		return "Success Delete Product!";
//	}
}
