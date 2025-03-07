package com.example.test.modules.loan.controller;

import com.example.test.modules.loan.model.Loan;
import com.example.test.modules.loan.service.LoanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/loans")
@CrossOrigin(origins = {"*"})
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
    public ResponseEntity<Map<String, String>> createLoan(@RequestBody Loan loan) {
        return loanService.createLoan(loan);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> returnLoan(@PathVariable("id") long id) {
        return loanService.returnLoan(id);
    }
}
