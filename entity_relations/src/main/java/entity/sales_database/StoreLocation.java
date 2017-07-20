package entity.sales_database;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "store_location")
public class StoreLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String locationName;

    @OneToMany(targetEntity = Sale.class)
    private Set<Sale> salesInStore;
}
