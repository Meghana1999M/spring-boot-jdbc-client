package com.example.spring_boot_jdbc_client.controller;

import com.example.spring_boot_jdbc_client.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.spring_boot_jdbc_client.entity.Book;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/book")
    public String addNewBook(@RequestBody Book book) {
        return bookService.addNewBook(book);
    }

    @GetMapping("/books")
    public List<Book> fetchAllBooks() {
        return bookService.fetchAllBooks();
    }

    @GetMapping("/book/{id}")
    public Book fetchBookById(@PathVariable int id) {
        return bookService.fetchBookById(id);
    }

    @PutMapping("/book/{id}")
    public String updateBook(@PathVariable int id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/book/{id}")
    public String deleteBook(@PathVariable int id, @RequestBody Book book) {
        return bookService.deleteBook(id, book);
    }
}