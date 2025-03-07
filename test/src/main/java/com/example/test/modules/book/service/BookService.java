package com.example.test.modules.book.service;

import com.example.test.modules.book.model.Book;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookService {
    ResponseEntity<List<Book>> findAll();
    ResponseEntity<Book> findById(long id);
    ResponseEntity<String> save(Book book);
    ResponseEntity<String> update(Book book);
    ResponseEntity<String> deleteById(long id);
}
