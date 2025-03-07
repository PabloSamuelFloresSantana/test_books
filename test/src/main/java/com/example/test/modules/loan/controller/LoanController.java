package com.example.test.modules.loan.controller;

import com.example.test.modules.loan.model.Loan;
import com.example.test.modules.loan.service.LoanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/loans")
public class LoanController {
    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping
    public ResponseEntity<List<Loan>> findAll() {
        return loanService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Loan> findById(@PathVariable("id") long id) {
        return loanService.findById(id);
    }

    @PostMapping
    public ResponseEntity<String> createLoan(@RequestBody Loan loan) {
        return loanService.createLoan(loan);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> returnLoan(@PathVariable("id") long id) {
        return loanService.returnLoan(id);
    }
}
