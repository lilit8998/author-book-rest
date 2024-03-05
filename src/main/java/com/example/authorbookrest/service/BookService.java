package com.example.authorbookrest.service;

import com.example.authorbookrest.entity.Book;

import java.util.List;

public interface BookService {
    Book create(Book book);

    List<Book> getAll();

    Book getById(int id);

    Book update(int id, Book book);
    void deleteById(int id);
}
