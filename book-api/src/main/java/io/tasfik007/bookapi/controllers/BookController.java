package io.tasfik007.bookapi.controllers;

import io.tasfik007.bookapi.domains.Book;
import io.tasfik007.bookapi.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/api/books")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/api/books/{isbn}")
    public Book getBook(@PathVariable int isbn){
        return bookService.getBook(isbn);
    }

    @PostMapping("/api/books")
    public void addBook(@RequestBody Book book){
        bookService.addBook(book);
    }

    @PutMapping("/api/books/{isbn}")
    public void updateBook(@RequestBody Book book,@PathVariable int isbn){
        bookService.updateBook(book, isbn);
    }

    @DeleteMapping("/api/books/{isbn}")
    public void deleteBook(@PathVariable int isbn){
        bookService.deleteBook(isbn);
    }


}
