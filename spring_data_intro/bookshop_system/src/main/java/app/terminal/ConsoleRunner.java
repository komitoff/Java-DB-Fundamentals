package app.terminal;

import app.entity.Author;
import app.entity.Book;
import app.entity.Category;
import app.repository.AuthorRepository;
import app.service.author.AuthorService;
import app.service.book.BookService;
import app.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class ConsoleRunner implements CommandLineRunner {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public void run(String... strings) throws Exception {
        /** task 1 and 2 **/
//     Remove the comments from this piece of code to seed data into database
//     Also change the spring.jpa.hibernate.ddl-auto = create into application.properties file
//        try {
//           seedData();
//        } catch (IOException ioe) {
//            System.out.println(ioe.getMessage());
//        }

        //task 3
/*        Calendar cal = Calendar.getInstance();
        cal.set(2000, 1, 1);
        Date date = cal.getTime();

        List<Book> booksAfter2000 = bookService.getAllBooksAfterYear(date);
        booksAfter2000.forEach(x -> System.out.println(x.getTitle()));*/

        Calendar cal = Calendar.getInstance();
        cal.set(1990, 1, 1);
        Date date = cal.getTime();
        List<Author> authors = authorRepository.findAllWithBookReleaseDateBefore(date);
    }

    public void seedData() throws IOException, ParseException {
        Random random = new Random();
        List<Author> authors = new ArrayList<>();
        List<Category> categories = new ArrayList<>();
        BufferedReader authorReader = new BufferedReader(new FileReader("authors.txt"));
        String authorLine = authorReader.readLine();

        while ((authorLine = authorReader.readLine()) != null) {
            String[] data = authorLine.split("\\s+");
            Author author = new Author(data[0], data[1]);
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
        while((line = booksReader.readLine()) != null){
            String[] data = line.split("\\s+");
            authors = authorService.findAll();
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
            Set<Category> categorySet = new HashSet<>();
            categorySet.add(categories.get(random.nextInt(categories.size())));
            book.setCategory(categorySet);
            //TODO add random categories for current book

            bookService.save(book);
        }
    }
}
