package app.service.impl;

import app.repository.api.AuthorRepository;
import app.entities.Author;
import app.service.api.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public void delete(Long id) {
        authorRepository.delete(id);
    }

    @Override
    public Author findAuhor(Long id) {
        return authorRepository.findOne(id);
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public void save(Author author) {
        authorRepository.save(author);
    }

    @Override
    public void printAuthor(Author author) {
        System.out.println(author);
    }

    @Override
    public List<Author> findAuthorsWithBookReleasedBefore1990() {
        return authorRepository.findAuthorsWithBookReleasedBefore1990();
    }

    @Override
    public List<Object[]> findAuthorByBooksCount(){
        return authorRepository.findAuthorByBooksCount();
    }


}
