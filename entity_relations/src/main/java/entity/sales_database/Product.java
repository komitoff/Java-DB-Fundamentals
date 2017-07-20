package entity.sales_database;

import javafx.scene.effect.SepiaTone;

import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by tobieski on 7/20/2017.
 */
public class Product {

    private Long id;

    private String name;

    private Double quantity;

    private BigDecimal price;

    private Set<Sale> salesOfProduct;
}
