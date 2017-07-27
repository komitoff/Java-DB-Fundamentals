package app.service.api;


import app.entities.AgeRestriction;
import app.entities.Book;
import app.entities.EditionType;

import java.util.Date;
import java.util.List;

public interface BookService<Book, Long> {
    List<Book> findAll ();

    void save(Book book);

    Book findBookByTitle(String title);

    void printBook(Book book);

    List<Book> findByReleaseDateAfter(Date date);

    List<Book> getBooksByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(String firstName, String lastName);

    List<Book> getBooksByReleaseDateBefore(Date date);

    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findByPrice();
}
