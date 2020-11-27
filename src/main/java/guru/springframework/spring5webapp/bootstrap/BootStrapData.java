package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
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

        System.out.println("Started in BootStrap");
        System.out.println("Numero di libri: "+bookRepository.count());

    }
}
