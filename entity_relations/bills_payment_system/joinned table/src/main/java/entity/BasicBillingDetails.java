package entity;

import javax.persistence.*;

@Entity
@Table(name = "billing_details")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BasicBillingDetails implements BillingDetails{
    private Long id;
    private String number;
    private User owner;

    protected BasicBillingDetails() {}

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    @ManyToOne
    @JoinColumn(name = "owner_id",
    referencedColumnName = "id")
    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
