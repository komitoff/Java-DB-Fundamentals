package app.service.author;

import app.entity.Author;

import java.util.List;

public interface AuthorService {
    void save(Author author);
    List<Author> findAll();
}
