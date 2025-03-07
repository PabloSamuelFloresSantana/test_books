package com.example.test.modules.book.controller;

import com.example.test.modules.book.model.Book;
import com.example.test.modules.book.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable("id") long id) {
        return bookService.findById(id);
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Book book) {
        return bookService.save(book);
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody Book book) {
        return bookService.update(book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") long id) {
        return bookService.deleteById(id);
    }
}
