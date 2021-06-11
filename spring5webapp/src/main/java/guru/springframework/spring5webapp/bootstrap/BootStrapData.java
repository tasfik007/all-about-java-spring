package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Bootstrap starts....");

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publisher");
        publisher.setCity("St Petersburg");
        publisher.setState("FL");
        publisherRepository.save(publisher);

        System.out.println("Publisher Count: "+publisherRepository.count());

        Author eric = new Author("Eric","Evans");
        Book book1 = new Book("Domain Driver Design","1324657");
        eric.getBooks().add(book1);
        book1.getAuthors().add(eric);
        book1.setPublisher(publisher);
        authorRepository.save(eric);
        bookRepository.save(book1);

        Author rod = new Author("Rod", "Jonson");
        Book book2 = new Book("J2EE","4756098");
        rod.getBooks().add(book2);
        book2.getAuthors().add(rod);
        book2.setPublisher(publisher);
        authorRepository.save(rod);
        bookRepository.save(book2);

        publisher.getBooks().add(book1);
        publisher.getBooks().add(book2);
        publisherRepository.save(publisher);
        System.out.println("Publisher Book Count: "+ publisher.getBooks().size());

        System.out.println("Total Books in Book Repository:  "+bookRepository.count());

    }
}
