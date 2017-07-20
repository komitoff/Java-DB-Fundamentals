package entity.sales_database;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sale")
public class Sale {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Product product;

    private Customer customer;

    private StoreLocation storeLocation;

    @Column
    private Date date;
}
