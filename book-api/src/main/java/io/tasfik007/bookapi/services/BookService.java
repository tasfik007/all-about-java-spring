package io.tasfik007.bookapi.services;

import io.tasfik007.bookapi.domains.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BookService {
    private final List<Book> books;

    public BookService() {
        //Initial dump data to test
        this.books = new ArrayList<>( Arrays.asList(
                new Book("Book1 title",532352,"Peter","Publisher 1"),
                new Book("Book2 title",1862352,"Tony","Publisher 2"),
                new Book("Book3 title",342352,"Chris","Publisher 3"),
                new Book("Book4 title",520352,"Andrew","Publisher 4")
        ));
    }

    public List<Book> getAllBooks() {
        return books;
    }
    public Book getBook(int isbn){
        return books.stream()
                .filter(book->book.getIsbn() == isbn)
                .findFirst().get();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void updateBook(Book newBook, int isbn) {
        for(int i=0; i<books.size(); i++){
            Book curBook = books.get(i);
            if(curBook.getIsbn() == isbn){
                books.set(i,newBook);
                break;
            }
        }
    }

    public void deleteBook(int isbn) {
        books.removeIf(book -> book.getIsbn()==isbn);
    }
}
