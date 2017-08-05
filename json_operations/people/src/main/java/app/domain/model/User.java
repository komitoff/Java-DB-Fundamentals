package app.domain.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements Serializable{
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Set<Product> productsSold;
    private Set<Product> productBought;
    private Set<User> friends;

    public User() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "first_name")
    @Basic(optional = true)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    @Basic(optional = false)
    @Length(min = 3)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "age")
    @Basic(optional = true)
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @OneToMany(mappedBy = "id")
    public Set<Product> getProductsSold() {
        return productsSold;
    }

    public void setProductsSold(Set<Product> productsSold) {
        this.productsSold = productsSold;
    }

    @OneToMany(mappedBy = "id")
    public Set<Product> getProductBought() {
        return productBought;
    }

    public void setProductBought(Set<Product> productBought) {
        this.productBought = productBought;
    }

    @ManyToMany
    @JoinTable(name = "user_friends",
    joinColumns = @JoinColumn(name = "user_id",
    referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "friend_id",
    referencedColumnName = "id"),
    foreignKey = @ForeignKey(name = "FK_user_user_friends"),
    inverseForeignKey = @ForeignKey(name = "FK_friends_user_user"))
    public Set<User> getFriends() {
        return friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }
}
