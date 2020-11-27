package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRpository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRpository publisherRpository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRpository publisherRpository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRpository = publisherRpository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author auth1 = new Author("Marco", "Lanfranchi");
        Book book1 = new Book("Programmare", "12345");
        auth1.getBooks().add(book1);
        book1.getAuthors().add(auth1);
        authorRepository.save(auth1);
        bookRepository.save(book1);

        Author auth2 = new Author("Roberto", "Gazia");
        Book book2 = new Book("ProgrammareBene", "67890");
        auth2.getBooks().add(book2);
        book2.getAuthors().add(auth2);
        authorRepository.save(auth2);
        bookRepository.save(book2);

        Publisher pub1 = new Publisher("Editore1", "Via Milano, 4", "Lecco", "Italia", "23900");
        publisherRpository.save(pub1);

        System.out.println("Started in BootStrap");
        System.out.println("Numero di libri: "+bookRepository.count());
        System.out.println("Numero di publisher: "+publisherRpository.count());

    }
}
