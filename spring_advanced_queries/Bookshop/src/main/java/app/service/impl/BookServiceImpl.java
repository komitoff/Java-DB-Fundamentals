package app.service.impl;

import app.entities.AgeRestriction;
import app.entities.EditionType;
import app.repository.api.BookRepository;
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
    private BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Book findBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    @Override
    public void printBook(Book book) {
        System.out.println(book);
    }

    @Override
    public List<Book> findByReleaseDateAfter(Date date) {
        return bookRepository.findAllByReleaseDateAfter(date);
    }

    @Override
    public List<Book> getBooksByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(String firstName, String lastName) {
        return bookRepository.getBooksByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(firstName, lastName);
    }

    @Override
    public List<Book> getBooksByReleaseDateBefore(Date date) {
        return bookRepository.getBooksByReleaseDateBefore(date);
    }

    @Override
    public List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction) {
        return this.bookRepository.findAllByAgeRestriction(ageRestriction);
    }

    @Override
    public List<Book> findByPrice() {
        return this.bookRepository.findAllByPrice();
    }
}
