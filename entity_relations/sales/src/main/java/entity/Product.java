package entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {

    private Long id;
    private String name;
    private Double quantity;
    private BigDecimal price;
    private Set<Sale> salesOfProduct;

    public Product() {}

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

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column(name = "sales_of_product")
    @OneToMany(mappedBy = "product")
    public Set<Sale> getSalesOfProduct() {
        return salesOfProduct;
    }

    public void setSalesOfProduct(Set<Sale> salesOfProduct) {
        this.salesOfProduct = salesOfProduct;
    }
}
