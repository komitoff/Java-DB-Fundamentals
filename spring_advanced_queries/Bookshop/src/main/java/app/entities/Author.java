package app.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "authors")
public class Author implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private Set<Book> booksByAuthor;

    public Author() {
        this.booksByAuthor = new HashSet<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "fisrt_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "author", fetch = FetchType.EAGER)
    public Set<Book> getBooksByAuthor() {
        return booksByAuthor;
    }

    public void setBooksByAuthor(Set<Book> booksByAuthor) {
        this.booksByAuthor = booksByAuthor;
    }



    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
//                ", booksByAuthor=" + booksByAuthor +
                '}';
    }
}