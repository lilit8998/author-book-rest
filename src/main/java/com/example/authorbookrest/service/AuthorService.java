package com.example.authorbookrest.service;

import com.example.authorbookrest.entity.Author;
import com.example.authorbookrest.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AuthorService {
    Author create(Author author);

    List<Author> getAll();

    Author getById(int id);

    Author update(int id, Author author);

    void deleteById(int id);
}
