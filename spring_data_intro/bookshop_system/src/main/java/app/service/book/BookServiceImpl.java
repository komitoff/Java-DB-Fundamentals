package app.service.book;

import app.entity.Book;
import app.repository.BookRepository;
import app.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooksAfterYear(Date date) {
        return this.bookRepository.findByReleaseDateAfter(date);
    }

    @Override
    public List<Book> findBooks() {
        return this.bookRepository.findAll();
    }

}
