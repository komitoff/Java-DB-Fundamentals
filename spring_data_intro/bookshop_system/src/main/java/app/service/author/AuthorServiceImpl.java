package app.service.author;

import app.entity.Author;
import app.repository.AuthorRepository;
import app.service.author.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public void save(Author author) {
        authorRepository.save(author);
    }
}
