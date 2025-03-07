package com.example.test.modules.book.service;

import com.example.test.modules.book.model.Book;
import com.example.test.modules.book.model.BookMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<Map<String, String>> save(Book book) {
        Map<String, String> response = new HashMap<>();
        try {
            bookMapper.save(book);
            response.put("message", "Libro creado exitosamente.");
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            response.put("message", "Error al crear el libro");
            response.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }


    @Override
    public ResponseEntity<Map<String, String>> update(Book book) {
        Map<String, String> response = new HashMap<>();
        Book existingBook = bookMapper.findById(book.getId());

        if (existingBook == null) {
            response.put("message", "El libro no existe.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        try {
            bookMapper.update(book);
            response.put("message", "Libro actualizado exitosamente.");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("message", "Error al actualizar el libro");
            response.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @Override
    public ResponseEntity<Map<String, String>> deleteById(long id) {
        Map<String, String> response = new HashMap<>();
        Book existingBook = bookMapper.findById(id);

        if (existingBook == null) {
            response.put("message", "El libro no existe.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        try {
            bookMapper.deleteById(id);
            response.put("message", "Libro eliminado exitosamente.");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("message", "Error al eliminar el libro");
            response.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
