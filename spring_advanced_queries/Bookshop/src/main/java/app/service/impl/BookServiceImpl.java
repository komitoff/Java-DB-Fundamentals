package app.service.impl;

import app.dao.api.BooksDao;
import app.entities.Book;
import app.service.api.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService<Book, Long> {

    @Autowired
    private BooksDao booksDao;

    @Override
    public List<Book> findAll() {
        return booksDao.findAll();
    }

    @Override
    public void save(Book book) {
        booksDao.save(book);
    }

    @Override
    public Book findBookByTitle(String title) {
        return booksDao.findByTitle(title);
    }

    @Override
    public void printBook(Book book) {
        System.out.println(book);
    }

    @Override
    public List<Book> findByReleaseDateAfter(Date date) {
        return booksDao.findAllByReleaseDateAfter(date);
    }

    @Override
    public List<Book> getBooksByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(String firstName, String lastName) {
        return booksDao.getBooksByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(firstName, lastName);
    }

    @Override
    public List<Book> getBooksByReleaseDateBefore(Date date) {
        return booksDao.getBooksByReleaseDateBefore(date);
    }


}
