package entity.sales_database;

import com.sun.javafx.beans.IDProperty;
import javafx.scene.effect.SepiaTone;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by tobieski on 7/20/2017.
 */
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;

    @Column
    private Double quantity;

    @Column
    private BigDecimal price;

    @ManyToOne(targetEntity = Sale.class)
    private Set<Sale> salesOfProduct;
}
