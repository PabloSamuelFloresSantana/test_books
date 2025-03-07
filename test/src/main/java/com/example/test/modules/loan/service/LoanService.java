package com.example.test.modules.loan.service;

import com.example.test.modules.loan.model.Loan;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface LoanService {
    ResponseEntity<List<Loan>> findAll();
    ResponseEntity<Loan> findById(long id);
    ResponseEntity<Map<String, String>> createLoan(Loan loan);
    ResponseEntity<Map<String, String>> returnLoan(long id);
}
