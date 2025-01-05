package com.parkee.rest_book_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parkee.rest_book_api.model.Borrower;

public interface BorrowerRepository extends JpaRepository<Borrower, String> {
	Borrower findByKtp(String ktp);
	void deleteByKtp(String ktp);
}
