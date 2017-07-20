package entity.sales_database;

import java.util.Set;

/**
 * Created by tobieski on 7/20/2017.
 */
public class Customer {

    private Long id;

    private String name;

    private String email;

    private String creditCardNumber;

    private Set<Sale> salesOfCustomer;
}
