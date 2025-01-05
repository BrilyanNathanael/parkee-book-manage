package com.parkee.rest_book_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.parkee.rest_book_api.model.BookBorrower;

public interface BookBorrowerRepository extends JpaRepository<BookBorrower, Integer>{
	BookBorrower findByBorrower_Ktp(String ktp);
	   
	@Query("SELECT bb FROM BookBorrower bb WHERE bb.borrower.ktp = :ktp AND bb.book.isbn = :isbn AND bb.is_returned = 'N'")
	BookBorrower findByKtpAndIsbn(@Param("ktp") String ktp, @Param("isbn") String isbn);

	@Query("SELECT bb FROM BookBorrower bb " +
		       "JOIN FETCH bb.book b " +
		       "JOIN FETCH bb.borrower br")
		List<BookBorrower> findAllBooksWithBorrowers();
	
	@Query("SELECT bb FROM BookBorrower bb " +
		       "JOIN FETCH bb.book b " +
		       "JOIN FETCH bb.borrower br " +
		       "WHERE bb.returned_dt <= bb.deadline_dt")
		List<BookBorrower> findAllBooksWithBorrowersOnTime();
	
	@Query("SELECT bb FROM BookBorrower bb " +
		       "JOIN FETCH bb.book b " +
		       "JOIN FETCH bb.borrower br " +
		       "WHERE bb.returned_dt > bb.deadline_dt")
		List<BookBorrower> findAllBooksWithBorrowersOverDeadline();
}
