package com.techmaster.demo.repository;

import java.util.concurrent.ConcurrentHashMap;

import com.techmaster.demo.model.Book;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepo {
    ConcurrentHashMap<String, Book> books;

    public BookRepo() {
        books = new ConcurrentHashMap<>();
        books.put("b1", new Book("b1", "aaa1", "bbb1"));
        books.put("b2", new Book("b2", "aaa2", "bbb2"));
        books.put("b3", new Book("b3", "aaa3", "bbb3"));
    }

    public ConcurrentHashMap<String, Book> getBooks() {
        return books;
    }
}
