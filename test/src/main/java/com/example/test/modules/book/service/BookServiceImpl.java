package com.example.test.modules.book.service;

import com.example.test.modules.book.model.Book;
import com.example.test.modules.book.model.BookMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookMapper bookMapper;

    public BookServiceImpl(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public ResponseEntity<List<Book>> findAll() {
        List<Book> books = bookMapper.findAll();
        if (books.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(books);
        }
        return ResponseEntity.ok(books);
    }

    @Override
    public ResponseEntity<Book> findById(long id) {
        Book book = bookMapper.findById(id);
        if (book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(book);
    }

    @Override
    public ResponseEntity<String> save(Book book) {
        try {
            bookMapper.save(book);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Libro creado exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al crear el libro: " + e.getMessage());
        }
    }

    @Override
    public ResponseEntity<String> update(Book book) {
        Book existingBook = bookMapper.findById(book.getId());
        if (existingBook == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El libro no existe.");
        }

        try {
            bookMapper.update(book);
            return ResponseEntity.ok("Libro actualizado exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al actualizar el libro: " + e.getMessage());
        }
    }

    @Override
    public ResponseEntity<String> deleteById(long id) {
        Book existingBook = bookMapper.findById(id);
        if (existingBook == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El libro no existe.");
        }

        try {
            bookMapper.deleteById(id);
            return ResponseEntity.ok("Libro eliminado exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al eliminar el libro: " + e.getMessage());
        }
    }
}
