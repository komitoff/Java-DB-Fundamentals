package app.service.api;
import app.entities.Author;
import app.entities.Book;

import java.util.Date;
import java.util.List;

public interface AuthorService<Author, Long> {

    void delete(Long id);

    Author findAuhor(Long id);

    List<Author> findAll ();

    void save(Author author);

    void printAuthor(Author author);

    List<Author> findAuthorsWithBookReleasedBefore1990();

    List<Object[]> findAuthorByBooksCount();


}
