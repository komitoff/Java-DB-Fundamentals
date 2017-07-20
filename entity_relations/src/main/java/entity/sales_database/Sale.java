package entity.sales_database;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sale")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @ManyToOne(targetEntity = Product.class)
    private Product product;

    @Column
    @ManyToOne(targetEntity = Customer.class)
    private Customer customer;

    @Column
    @ManyToOne
    private StoreLocation storeLocation;

    @Column
    private Date date;
}
