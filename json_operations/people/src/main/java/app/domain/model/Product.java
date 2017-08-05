package app.domain.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product implements Serializable {
    private Long id;
    private String name;
    private BigDecimal price;
    private User bayerId;
    private User sellerId;
    private Set<Category> categories;

    public Product () {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    @Length(min = 3)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "buyer_id",
    referencedColumnName = "id",
    foreignKey = @ForeignKey(name = "FK_product_buyer"))
    public User getBayerId() {
        return bayerId;
    }

    public void setBayerId(User bayerId) {
        this.bayerId = bayerId;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "seller_id",
    referencedColumnName = "id",
    foreignKey = @ForeignKey(name = "FK_product_seller"))
    public User getSellerId() {
        return sellerId;
    }

    public void setSellerId(User sellerId) {
        this.sellerId = sellerId;
    }

    @ManyToMany
    @JoinTable(name = "categories_products",
    joinColumns = @JoinColumn(name = "category_id",
    referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "product_id",
    referencedColumnName = "id"),
    foreignKey = @ForeignKey(name = "fk_products_categories_products"),
    inverseForeignKey = @ForeignKey(name = "fk_products_categories_categories"))
    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
