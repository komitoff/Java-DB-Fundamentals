package app.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book implements Serializable {
    private int id;
    private String title;
    private Author author;
    private String description;
    private EditionType editionType;
    private BigDecimal price;
    private int copies;
    private Date releaseDate;
    private AgeRestriction ageRestriction;
    private Set<Category> categories;
    private Set<Book> relatedBooks;


    public Book() {
        this.categories = new HashSet<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "title", nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "books_categories",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    @Column(name ="price", nullable = false)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column(name = "copies", nullable = false)
    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    @Column(name = "release_date")
    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Column(name = "description", columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "edition_type", nullable = false)
    public EditionType getEditionType() {
        return editionType;
    }

    public void setEditionType(EditionType editionType) {
        this.editionType = editionType;
    }

    @Column(name = "age_restriction", nullable = false)
    public AgeRestriction getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(AgeRestriction ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "related_books",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "related_id")
    )
    public Set<Book> getRelatedBooks() {
        return relatedBooks;
    }

    public void setRelatedBooks(Set<Book> relatedBooks) {
        this.relatedBooks = relatedBooks;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
//                ", author=" + author +
                ", description='" + description + '\'' +
                ", editionType='" + editionType + '\'' +
                ", price=" + price +
                ", copies=" + copies +
                ", releaseDate=" + releaseDate +
                ", ageRestriction=" + ageRestriction +
//                ", categories=" + categories +
                '}';
    }
}