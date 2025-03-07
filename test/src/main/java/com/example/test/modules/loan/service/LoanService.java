package com.example.test.modules.loan.service;

import com.example.test.modules.loan.model.Loan;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LoanService {
    ResponseEntity<List<Loan>> findAll();
    ResponseEntity<Loan> findById(long id);
    ResponseEntity<String> createLoan(Loan loan);
    ResponseEntity<String> returnLoan(long id);
}
