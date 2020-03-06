package guru.springframework.spring5webapp.bootsrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


//
@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;


    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author angelis = new Author("Angelis","Davelos");
        Book javaBook = new Book("enities","123213");
        angelis.getBooks().add(javaBook);
        javaBook.getAuthors().add(angelis);

        authorRepository.save(angelis);
        bookRepository.save(javaBook);

        Author thanos = new Author("Thanasis","Davelos");
        Book cBook = new Book("domains","23123412");
        thanos.getBooks().add(cBook);
        cBook.getAuthors().add(thanos);

        authorRepository.save(thanos);
        bookRepository.save(cBook);

        System.out.println("Starter in Bootstrap");
        System.out.println("Number of Books : " + bookRepository.count());

        Publisher publisher = new Publisher("SAF","as");

        publisherRepository.save(publisher);

        System.out.println("Nyumbner of puiblishers : " + publisherRepository.count());

        cBook.setPublisher(publisher);
        publisher.getBooks().add(cBook);
        javaBook.setPublisher(publisher);
        publisher.getBooks().add(javaBook);
        System.out.println("Publisher numner of books: " + publisher.getBooks().size());



    }
}
