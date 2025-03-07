package com.example.test.modules.book.service;

import com.example.test.modules.book.model.Book;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface BookService {
    ResponseEntity<List<Book>> findAll();
    ResponseEntity<Book> findById(long id);
    ResponseEntity<Map<String, String>> save(Book book);
    ResponseEntity<Map<String, String>> update(Book book);
    ResponseEntity<Map<String, String>> deleteById(long id);
}
