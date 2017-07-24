package app.repository;

import app.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

//    SELECT a.first_name, a.last_name, Count(b.id)
//    FROM author AS a
//    INNER JOIN
//    book AS b
//            ON
//    a.id = b.author_id
//            WHERE
//    YEAR(b.release_date) < '1990'
//    GROUP BY
//    a.id;

    @Query(value = "SELECT a.first_name, a.last_name, COUNT(*) as booksCount " +
            "FROM Author a INNER JOIN Book b ON a.id = b.author_id " +
            "WHERE b.release_date < ?1 " +
            "GROUP BY a.id;",
            nativeQuery = true)
    List<Author> findAllWithBookReleaseDateBefore(Date releaseDate);
}
