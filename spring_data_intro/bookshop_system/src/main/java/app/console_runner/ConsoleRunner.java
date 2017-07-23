package app.console_runner;

import app.entity.Author;
import app.entity.Book;
import app.entity.Category;
import app.service.author.AuthorService;
import app.service.book.BookService;
import app.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Component
public class ConsoleRunner implements CommandLineRunner {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @Override
    public void run(String... strings) throws Exception {
        Random random = new Random();
        List<Author> authors = new ArrayList<>();
        List<Category> categories = new ArrayList<>();
        BufferedReader authorReader = new BufferedReader(new FileReader("authors.txt"));
        String authorLine = authorReader.readLine();

        while ((authorLine = authorReader.readLine()) != null) {
            String[] data = authorLine.split("\\s+");
            Author author = new Author(data[0], data[1]);
            authors.add(new Author(data[0], data[1]));
            authorService.save(author);
        }
        authorReader.close();

        BufferedReader categoryReader = new BufferedReader(new FileReader("categories.txt"));
        String categoryLine = categoryReader.readLine();

        while (categoryLine != null) {
            String data = categoryLine.trim();
            Category category = new Category(data);
            categories.add(category);
            categoryService.save(category);
            categoryLine = categoryReader.readLine();
        }

        BufferedReader booksReader = new BufferedReader(new FileReader("books.txt"));
        String line = booksReader.readLine();
        while ((line = booksReader.readLine()) != null) {
            String[] data = line.split("\\s+");

            int authorIndex = random.nextInt(authors.size());
            Author author = authors.get(authorIndex);
            String editionType = data[0];
            SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy");
            Date releaseDate = formatter.parse(data[1]);
            int copies = Integer.parseInt(data[2]);
            BigDecimal price = new BigDecimal(data[3]);
            String ageRestriction = data[4];
            StringBuilder titleBuilder = new StringBuilder();
            for (int i = 5; i < data.length; i++) {
                titleBuilder.append(data[i]).append(" ");
            }
            titleBuilder.delete(titleBuilder.lastIndexOf(" "), titleBuilder.lastIndexOf(" "));
            String title = titleBuilder.toString();

            Book book = new Book();
            book.setAuthor(author);
            book.setEditionType(editionType);
            book.setReleaseDate(releaseDate);
            book.setCopies(copies);
            book.setPrice(price);
            book.setAgeRestriction(ageRestriction);
            book.setTitle(title);
            //TODO add random categories for current book
            int categoryIndex = random.nextInt(categories.size());
            book.setCategory(categories.get(categoryIndex));

            bookService.save(book);

            System.out.println("hello runner");
        }
    }
}
