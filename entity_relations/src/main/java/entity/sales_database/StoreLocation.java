package entity.sales_database;

import java.util.Set;

/**
 * Created by tobieski on 7/20/2017.
 */
public class StoreLocation {

    private Long id;

    private String locationName;

    private Set<Sale> salesInStore;
}
