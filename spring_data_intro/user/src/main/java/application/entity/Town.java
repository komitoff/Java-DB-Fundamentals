package application.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "town")
public class Town {
    private Long id;
    private String name;
    private List<User> users;

    public Town() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany
    @JoinColumn(name = "user_id",
    referencedColumnName = "id",
    foreignKey = @ForeignKey(name = "FK_users_towns"))
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
