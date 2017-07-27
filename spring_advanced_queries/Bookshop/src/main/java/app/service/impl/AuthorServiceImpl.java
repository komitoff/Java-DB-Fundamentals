package app.service.impl;

import app.dao.api.AuthorsDao;
import app.entities.Author;
import app.service.api.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService<Author, Long>{

    @Autowired
    private AuthorsDao authorsDao;


    @Override
    public void delete(Long id) {
        authorsDao.delete(id);
    }

    @Override
    public Author findAuhor(Long id) {
        return authorsDao.findOne(id);
    }

    @Override
    public List<Author> findAll() {
        return authorsDao.findAll();
    }

    @Override
    public void save(Author author) {
        authorsDao.save(author);
    }

    @Override
    public void printAuthor(Author author) {
        System.out.println(author);
    }

    @Override
    public List<Author> findAuthorsWithBookReleasedBefore1990() {
        return authorsDao.findAuthorsWithBookReleasedBefore1990();
    }

    @Override
    public List<Object[]> findAuthorByBooksCount(){
        return authorsDao.findAuthorByBooksCount();
    }


}
