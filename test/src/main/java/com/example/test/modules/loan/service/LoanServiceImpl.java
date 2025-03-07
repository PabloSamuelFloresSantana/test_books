package com.example.test.modules.loan.service;

import com.example.test.modules.book.model.Book;
import com.example.test.modules.book.model.BookMapper;
import com.example.test.modules.loan.model.Loan;
import com.example.test.modules.loan.model.LoanMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LoanServiceImpl implements LoanService {
    private final BookMapper bookMapper;
    private final LoanMapper loanMapper;

    public LoanServiceImpl(BookMapper bookMapper, LoanMapper loanMapper) {
        this.bookMapper = bookMapper;
        this.loanMapper = loanMapper;
    }

    @Override
    public ResponseEntity<List<Loan>> findAll() {
        List<Loan> loans = loanMapper.findAll();
        if (loans.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(loans);
        }

        return ResponseEntity.ok(loans);
    }

    @Override
    public ResponseEntity<Loan> findById(long id) {
        Loan loan = loanMapper.findById(id);
        if (loan == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(loan);
    }

    // Crear un préstamo
    public ResponseEntity<Map<String, String>> createLoan(Loan loan) {
        Map<String, String> response = new HashMap<>();

        // Verificar si el libro existe
        Book book = bookMapper.findById(loan.getBookId());
        if (book == null) {
            response.put("message", "El libro consultado no existe.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        // Verificar si hay stock disponible
        if (book.getCurrentStock() <= 0) {
            response.put("message", "No hay stock disponible para el libro.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        try {
            // Crear el préstamo
            loanMapper.save(loan);

            // Disminuir el stock actual del libro
            bookMapper.decreaseCurrentStock(loan.getBookId());

            response.put("message", "Préstamo creado exitosamente.");
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            response.put("message", "Error al crear el préstamo");
            response.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // Devolver un préstamo
    public ResponseEntity<Map<String, String>> returnLoan(long loanId) {
        Map<String, String> response = new HashMap<>();

        // Obtener el préstamo
        Loan loan = loanMapper.findById(loanId);
        if (loan == null) {
            response.put("message", "El préstamo no existe.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        try {
            // Eliminar el préstamo
            loanMapper.deleteById(loanId);

            // Aumentar el stock actual del libro
            bookMapper.increaseCurrentStock(loan.getBookId());

            response.put("message", "Préstamo devuelto exitosamente.");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("message", "Error al devolver el préstamo");
            response.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
