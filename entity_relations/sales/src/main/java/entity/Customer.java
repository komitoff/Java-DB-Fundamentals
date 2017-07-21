package entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer {

    private Long id;
    private String name;
    private String email;
    private String creditCardNumber;
    private Set<Sale> salesOfProduct;

    private Customer() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    @Column(name = "credit_card_number")
    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    @Column(name = "sales_of_product")
    @OneToMany(mappedBy = "customer")
    public Set<Sale> getSalesOfProduct() {
        return salesOfProduct;
    }

    public void setSalesOfProduct(Set<Sale> salesOfProduct) {
        this.salesOfProduct = salesOfProduct;
    }
}
