package entity;

import javax.persistence.*;

@Entity
@Table(name = "person")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "position", discriminatorType = DiscriminatorType.STRING)
public class BasicPerson implements Person{

    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    protected BasicPerson() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "phone_number")
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    @Column(name = "first_name")
    public String getFirstName() {
        return null;
    }

    @Override
    @Column(name = "last_name")
    public String getLastName() {
        return null;
    }

    @Override
    @Column(name = "phone_number")
    public String getPhoneNumber() {
        return null;
    }
}
