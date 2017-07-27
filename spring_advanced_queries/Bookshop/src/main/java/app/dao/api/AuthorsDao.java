package app.dao.api;

import app.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AuthorsDao extends JpaRepository<Author, Long> {
    @Query(value = "SELECT DISTINCT a FROM Author a JOIN a.booksByAuthor b WHERE YEAR(b.releaseDate) < 1990")
    List<Author> findAuthorsWithBookReleasedBefore1990();

    @Query(value = "SELECT a.firstName, a.lastName, COUNT(b) AS books_count FROM Author a " +
            "INNER JOIN a.booksByAuthor b GROUP BY a.id ORDER BY books_count DESC")
    List<Object[]> findAuthorByBooksCount();


}
