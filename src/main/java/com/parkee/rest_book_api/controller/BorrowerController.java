package com.parkee.rest_book_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parkee.rest_book_api.model.Borrower;
import com.parkee.rest_book_api.service.BorrowerService;

@RestController
@RequestMapping("/borrower")
public class BorrowerController {
	@Autowired
	BorrowerService borrowerService;
	
	@GetMapping
	public List<Borrower> getAllBorrower() {
		return borrowerService.getAllBorrower();
	}
	
	@PostMapping
	public String addBorrower(@RequestBody Borrower borrower) {
		borrowerService.addBorrower(borrower);
		return "Success Add Borrower!";
	}
	
	@PutMapping("/{ktp}")
	public String updateBorrower(@PathVariable String ktp, @RequestBody Borrower borrower) {
		Borrower b = borrowerService.findByKtp(ktp);
		
		b.setName(borrower.getName());
		b.setEmail(borrower.getEmail());
		
		borrowerService.updateBorrower(b);
		return "Success Update Borrower!";
	}
	
	@DeleteMapping("/{ktp}")
	public String deleteByKtp(@PathVariable String ktp) {
		borrowerService.deleteByKtp(ktp);
		return "Success Delete Borrower!";
	}
}
