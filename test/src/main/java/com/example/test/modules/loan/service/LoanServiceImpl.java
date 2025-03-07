package com.example.test.modules.loan.service;

import com.example.test.modules.book.model.Book;
import com.example.test.modules.book.model.BookMapper;
import com.example.test.modules.loan.model.Loan;
import com.example.test.modules.loan.model.LoanMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public ResponseEntity<String> createLoan(Loan loan) {
        // Verificar si el libro existe
        Book book = bookMapper.findById(loan.getBookId());
        if (book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El libro consultado no existe.");
        }

        // Verificar si hay stock disponible
        if (book.getCurrentStock() <= 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("No hay stock disponible para el libro.");
        }

        // Crear el préstamo
        loanMapper.save(loan);

        // Disminuir el stock actual del libro
        bookMapper.decreaseCurrentStock(loan.getBookId());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Préstamo creado exitosamente.");
    }

    // Devolver un préstamo
    public ResponseEntity<String> returnLoan(long loanId) {
        // Obtener el préstamo
        Loan loan = loanMapper.findById(loanId);
        if (loan == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El préstamo no existe.");
        }

        // Eliminar el préstamo
        loanMapper.deleteById(loanId);

        // Aumentar el stock actual del libro
        bookMapper.increaseCurrentStock(loan.getBookId());

        return ResponseEntity.ok("Préstamo devuelto exitosamente.");
    }
}
