package application.entity;

import org.hibernate.annotations.FetchProfile;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    private Long id;
    private String username;
    private String password;
    private String email;
    private Byte[] profilePicture;
    private Date registeredOn;
    private Date lastTimeLoggedIn;
    private Integer age;
    private Boolean isDeleted;
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

    @Column(name = "name")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (username.length() < 4 || username.length() > 30) {
            throw new IllegalArgumentException("Username must be between 4 and 30 symbols");
        }
        this.username = username;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password.length() < 6 || password.length() > 50) {
            throw new IllegalArgumentException("Password must be between 6 and 50 symbols");
        }

        if (!password.matches(".*[a-z].*")) {
            throw new IllegalArgumentException("Password must contains at least one small letter");
        }

        if (!password.matches(".*[A-Z].*")) {
            throw new IllegalArgumentException("Password must contains at least one big letter");
        }

        if (!password.matches(".*[0-9].*")) {
            throw new IllegalArgumentException("Password must contains at least one digit");
        }

        if (!password.matches(".*[!, @, #, $, %, ^, &, *, (, ), _, +, <, >, ?].*")) {
            throw new IllegalArgumentException("Password must contains at least one special character");
        }

        this.password = password;

    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {

        if (!email.matches("[a-zA-Z0-9].*@[a-zA-Z0-9].*\\.[a-zA-Z].*")) {
            throw new IllegalArgumentException("Invalid email address");
        }
        this.email = email;
    }

    @Column(name = "profile_picture", columnDefinition = "LONGBLOB")
    public Byte[] getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(Byte[] profilePicture) {
//        if (profilePicture.length > 1024 * 1024) {
//            throw new IllegalArgumentException("Size of the picture is bigger than allowed");
//        }
        this.profilePicture = profilePicture;
    }

    @Column(name = "registered_on")
    public Date getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(Date registeredOn) {
        this.registeredOn = registeredOn;
    }

    @Column(name = "last_time_logged_in")
    public Date getLastTimeLoggedIn() {
        return lastTimeLoggedIn;
    }

    public void setLastTimeLoggedIn(Date lastTimeLoggedIn) {
        this.lastTimeLoggedIn = lastTimeLoggedIn;
    }

    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Column(name = "is_deleted")
    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    @OneToMany
    @JoinColumn(name = "friend_id",
    referencedColumnName = "id",
    foreignKey = @ForeignKey(name = "FK_user_friends"))
    public Set<User> getFriends() {
        return friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", profilePicture=" + Arrays.toString(profilePicture) +
                ", registeredOn=" + registeredOn +
                ", lastTimeLoggedIn=" + lastTimeLoggedIn +
                ", age=" + age +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
