package com.example.spring_boot_jdbc_client.service;

import com.example.spring_boot_jdbc_client.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private JdbcClient jdbcClient;

    public String addNewBook(Book book) {
        jdbcClient.sql("INSERT into Book(id, name, title) values(?, ?, ?)")
                .params(List.of(book.id(), book.name(), book.title()))
                .update();
        return "Book saved successfully";
    }

    public List<Book> fetchAllBooks() {
        return jdbcClient.sql("select id, name, title from Book").query(Book.class).list();
    }

    public Book fetchBookById(int id) {
        return jdbcClient.sql("select id, name, title from Book where id = :id")
                .param("id", id)
                .query(Book.class).optional().orElse(null);
    }

    public String updateBook(int id, Book book) {
        jdbcClient.sql("update Book set name = ?, title = ? where id = ?")
                .params(List.of(book.name(), book.title(), book.id()))
                .update();
        return "Book modified successfully";
    }

    public String deleteBook(int id, Book book) {
        jdbcClient.sql("delete from Book where id = ?")
                .params(List.of(book.name(), book.title(), book.id()))
                .update();
        return "Book modified successfully";
    }
}
