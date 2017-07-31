package app.repository.api;

import app.entities.AgeRestriction;
import app.entities.Book;
import app.entities.Category;
import app.entities.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
    Book findByTitle(String id);

    List<Book> findAllByReleaseDateAfter(Date date);

    List<Book> getBooksByReleaseDateBefore(Date date);

    List<Book> getBooksByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(String firstName, String lastName);

    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);
        //not finished
//    @Query(value = "SELECT b.title FROM Book b WHERE b.copies < 5000 AND b.editionType = 2")
//    List<String> getGoldenBooks(int editionType);

    @Query(value = "SELECT b FROM Book b WHERE b.price < 5 OR b.price > 40")
    List<Book> findAllByPrice();

    List<Book> findAllByReleaseDateGreaterThan(Date date);

    @Query(value = "SELECT b.title FROM bookshop_system.books AS b WHERE year(b.release_date) < :year", nativeQuery = true)
    List<String> getNotReleasedBooks(@Param("year") int year);

    @Query(value = "SELECT b.title\n" +
            "FROM books AS b\n" +
            "INNER JOIN books_categories AS bc\n" +
            "ON bc.book_id = b.book_id\n" +
            "INNER JOIN categories AS c\n" +
            "ON bc.category_id = c.category_id\n" +
            "WHERE c.name IN :categories",
    nativeQuery = true)
    List<String> getAllByCategories(@Param("categories") List<String> categories);

    @Query(value = "SELECT CONCAT_WS(\"-\", b.title, b.edition_type, b.price)\n" +
            "FROM books AS b\n" +
            "WHERE date(b.release_date) < :date",
    nativeQuery = true)
    List<String> findByReleaseDateBefore(@Param("date") String date);

    @Query(value = "SELECT b.title\n" +
            "FROM books AS b\n" +
            "WHERE b.title LIKE concat('%', :str, '%');",
    nativeQuery = true)
    List<String> getBooksContainingString(@Param("str") String str);


}
