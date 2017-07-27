package app.repository.api;

import app.entities.AgeRestriction;
import app.entities.Book;
import app.entities.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
    Book findByTitle(String id);

    List<Book> findAllByReleaseDateAfter(Date date);

    List<Book> getBooksByReleaseDateBefore(Date date);

    List<Book> getBooksByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(String firstName, String lastName);

    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

//    @Query(value = "SELECT b FROM Book b WHERE b.copies < 5000 AND b.edition_type = ?1")
//    List<Book> findAllByEditionType(EditionType editionType);

    @Query(value = "SELECT b FROM Book b WHERE b.price < 5 OR b.price > 40")
    List<Book> findAllByPrice();

    List<Book> findAllByReleaseDateGreaterThan(Date date);
}
