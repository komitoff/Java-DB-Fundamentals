package app.service.api;


import app.entities.AgeRestriction;
import app.entities.Book;
import app.entities.Category;
import app.entities.EditionType;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface BookService {
    List<Book> findAll ();

    void save(Book book);

    Book findBookByTitle(String title);

    void printBook(Book book);

    List<Book> findByReleaseDateAfter(Date date);

    List<Book> getBooksByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(String firstName, String lastName);

    List<Book> getBooksByReleaseDateBefore(Date date);

    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findByPrice();

   // List<String> getGoldenBooks(int editionType);

    List<String> getNotReleasedBooks(int year);

    List<String> getAllByCategories(List<String> categories);
}
