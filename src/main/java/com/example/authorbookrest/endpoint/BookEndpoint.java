package com.example.authorbookrest.endpoint;

import com.example.authorbookrest.entity.Author;
import com.example.authorbookrest.entity.Book;
import com.example.authorbookrest.service.AuthorService;
import com.example.authorbookrest.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/books")
public class BookEndpoint {
    private final BookService bookService;
    private final AuthorService authorService;

    @PostMapping("/{authorId}")
    public ResponseEntity<Book> createBook(@RequestBody Book book, @PathVariable("authorId") int authorId) {
        Author author = authorService.getById(authorId);
        if (author == null) {
            return ResponseEntity.notFound().build();
        }
        book.setAuthor(author);
        bookService.create(book);
        return ResponseEntity.ok(book);
    }

    @GetMapping()
    public List<Book> getAll() {
        return bookService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getById(@PathVariable("id") int id) {
        Book book = bookService.getById(id);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") int id,
                                           @RequestBody Book book) {
        Book book1 = bookService.getById(id);
        if (book1 == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bookService.update(id, book));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteById(@PathVariable("id") int id) {
        Book book = bookService.getById(id);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        bookService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
