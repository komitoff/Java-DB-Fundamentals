package game_store.entity;

import game_store.entity.enums.Role;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    private Long id;
    private String email;
    private String password;
    private String fullName;
    private Role role;
    private Set<Game> shoppingCartGames;
    private Set<Game> boughtGames;

    public User() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "full_name")
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Enumerated(EnumType.STRING)
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Column(name = "shopping_cart_games")
    @ManyToMany()
    @JoinTable(name = "users_cart_games",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "game_id"))
    public Set<Game> getShoppingCartGames() {
        return shoppingCartGames;
    }

    public void setShoppingCartGames(Set<Game> shoppingCartGames) {
        this.shoppingCartGames = shoppingCartGames;
    }

    @Column(name = "bought_games")
    @ManyToMany()
    @JoinTable(name = "users_bought_games",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "game_id"))
    public Set<Game> getBoughtGames() {
        return boughtGames;
    }

    public void setBoughtGames(Set<Game> boughtGames) {
        this.boughtGames = boughtGames;
    }
}
