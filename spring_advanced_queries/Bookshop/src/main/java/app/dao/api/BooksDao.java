package app.dao.api;

import app.entities.Author;
import app.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BooksDao extends JpaRepository<Book, Long>{
    Book findByTitle(String id);

    List<Book> findAllByReleaseDateAfter(Date date);

    List<Book> getBooksByReleaseDateBefore(Date date);

    List<Book> getBooksByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(String firstName, String lastName);
}
