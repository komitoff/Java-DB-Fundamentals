package entity.sales_database;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String creditCardNumber;

    @OneToMany(targetEntity = Sale.class)
    private Set<Sale> salesOfCustomer;
}
