package app.service.book;

import app.entity.Book;

import java.util.Date;
import java.util.List;

public interface BookService {
    void save(Book book);
    List<Book> getAllBooksAfterYear(Date date);
    List<Book> findBooks();
}
