package app;

import app.entities.*;
import app.repository.api.BookRepository;
import app.service.api.AuthorService;
import app.service.api.BookService;
import app.service.api.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class ConsoleRunner implements CommandLineRunner {

    @Autowired
    private BookService<Book, Long> bookService;

    @Autowired
    private AuthorService<Author, Long> authorService;

    @Autowired
    private CategoryService<Category, Long> categoryService;


    public void run(String... strings) throws Exception {
        //Problem 2. Seed Data into the Database
//        seedDatabase();
//        relatedBooks();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //1 Find by age restriction
//        String ageRestrictionType = reader.readLine();
//        booksByAgeRestriction(ageRestrictionType);

        //2 Golden Edition
//        String goldenType = "GOLD";
//        EditionType editionType = EditionType.valueOf(goldenType.toUpperCase());
//        List<Book> goldenEdition =
//                bookService.findAllByEditionType(editionType);
        //goldenEdition.stream().forEach(b -> System.out.println(b.getTitle()));

        //3 Find by price
//        List<Book> booksByPrice = bookService.findByPrice();
//        booksByPrice.stream().forEach(b -> System.out.println(
//                String.format("%s - %f $", b.getTitle(), b.getPrice())
//        ));

        //4


    }

    private void booksByAgeRestriction(String ageRestrictionType) {
        AgeRestriction ageRestriction = AgeRestriction.valueOf(ageRestrictionType.toUpperCase());
        List<Book> booksByAgeRestriction = this.bookService.findAllByAgeRestriction(ageRestriction);
        booksByAgeRestriction.stream().forEach(x -> System.out.println(x.getTitle()));
    }

    private void relatedBooks() {
        List<Book> books = (List<Book>) bookService.findAll();
        List<Book> threeBooks = books.subList(0, 3);

        threeBooks.get(0).getRelatedBooks().add(threeBooks.get(1));
        threeBooks.get(1).getRelatedBooks().add(threeBooks.get(0));
        threeBooks.get(0).getRelatedBooks().add(threeBooks.get(2));
        threeBooks.get(2).getRelatedBooks().add(threeBooks.get(0));

//save related books to the database
        for (Book book : threeBooks) {
            bookService.save(book);
        }

        for (Book book : threeBooks) {
            System.out.printf("--%s\n", book.getTitle());
            for (Book relatedBook : book.getRelatedBooks()) {
                System.out.println(relatedBook.getTitle());
            }
        }
    }

    private void getBooksFromAuthor() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        bookService.getBooksByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc("George", "Powell").stream().forEach(book -> System.out.println("Book title: " + book.getTitle() + "\n -- Release Date: " + dateFormat.format(book.getReleaseDate()) + "\n  -- Copies: " + book.getCopies()));

    }

    private void getAuthorsOrdered() {
        List<Object[]> authorsByBooksCount = authorService.findAuthorByBooksCount();
        for (Object[] objects : authorsByBooksCount) {
            System.out.println(objects[0] + " " + objects[1] + " " + objects[2]);
        }
    }

    private void getBooksBefore1990() {
        List<Author> authorsWithBooksBefore1990 = authorService.findAuthorsWithBookReleasedBefore1990();
        authorsWithBooksBefore1990.stream().forEach(author -> System.out.println(author.getFirstName() + " " + author.getLastName()));

        // the code below returns the same result, but the authors with more than one book before 1990 are repeated
        //        List<Book> booksBefore1990 = bookService.getBooksByReleaseDateBefore(new SimpleDateFormat("d/M/yyyy").parse("1/1/1990"));
//        for (Book book : booksBefore1990) {
//            System.out.println(book.getAuthor().getFirstName() + " " + book.getAuthor().getLastName());
//        }
    }

    private void getBooksAfter2000() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy");
        List<Book> booksAfter2000 = bookService.findByReleaseDateAfter(formatter.parse("31/12/2000"));
        booksAfter2000.stream().forEach(b -> System.out.println(b.getTitle()));
    }

    private void seedDatabase() throws IOException, ParseException {
        List<Author> authors = new ArrayList<>();
        List<Category> categories = new ArrayList<>();

        // Authors Table
        BufferedReader authorsReader = new BufferedReader(new FileReader("src\\main\\resources\\authors.txt"));
        String line = authorsReader.readLine();
        while ((line = authorsReader.readLine()) != null) {
            String[] data = line.split("\\s+");
            String firstName = data[0];
            String lastName = data[1];
            Author author = new Author();
            author.setFirstName(firstName);
            author.setLastName(lastName);
            authors.add(author);
            authorService.save(author);
        }

        //Categories Table
        BufferedReader categoriesReader = new BufferedReader(new FileReader("src\\main\\resources\\categories.txt"));
        while ((line = categoriesReader.readLine()) != null) {
            Category category = new Category();
            category.setName(line);
            categories.add(category);
            categoryService.save(category);
        }

        //Books table
        Random random = new Random();
        BufferedReader booksReader = new BufferedReader(new FileReader("src\\main\\resources\\books.txt"));
        line = booksReader.readLine();
        while ((line = booksReader.readLine()) != null) {
            String[] data = line.split("\\s+");

            int authorIndex = random.nextInt(authors.size());
            Author author = authors.get(authorIndex);
            EditionType editionType = EditionType.values()[Integer.parseInt(data[0])];
            SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy");
            Date releaseDate = formatter.parse(data[1]);
            int copies = Integer.parseInt(data[2]);
            BigDecimal price = new BigDecimal(data[3]);
            AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(data[4])];
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

            Set<Category> bookcategories = new HashSet<>();

            Category category1 = categories.get(random.nextInt(categories.size()));
            Category category2 = categories.get(random.nextInt(categories.size()));
            bookcategories.add(category1);
            bookcategories.add(category2);

            book.setCategories(bookcategories);

            bookService.save(book);
        }
    }
}
