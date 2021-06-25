package io.tasfik007.bookapi.domains;

public class Book {
    private String title;
    private int isbn;
    private String authorName;
    private String publisherName;

    public Book() {
    }
    public Book(String title, int isbn, String authorName, String publisherName) {
        this.title = title;
        this.isbn = isbn;
        this.authorName = authorName;
        this.publisherName = publisherName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }
}
