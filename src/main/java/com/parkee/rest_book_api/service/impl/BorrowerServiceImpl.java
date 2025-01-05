package com.parkee.rest_book_api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parkee.rest_book_api.model.Borrower;
import com.parkee.rest_book_api.repository.BorrowerRepository;
import com.parkee.rest_book_api.service.BorrowerService;

import jakarta.transaction.Transactional;

@Service
public class BorrowerServiceImpl implements BorrowerService {
	
	@Autowired
	BorrowerRepository borrowerRepository;

	@Override
	public List<Borrower> getAllBorrower() {
		// TODO Auto-generated method stub
		return borrowerRepository.findAll();
	}

	@Override
	public Borrower findByKtp(String ktp) {
		// TODO Auto-generated method stub
		return borrowerRepository.findByKtp(ktp);
	}

	@Override
	public void addBorrower(Borrower borrower) {
		// TODO Auto-generated method stub
		borrowerRepository.save(borrower);
	}

	@Override
	public void updateBorrower(Borrower borrower) {
		// TODO Auto-generated method stub
		borrowerRepository.save(borrower);
	}

	@Override
	@Transactional
	public void deleteByKtp(String ktp) {
		// TODO Auto-generated method stub
		borrowerRepository.deleteByKtp(ktp);
	}

}
