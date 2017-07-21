package entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "store_location")
public class StoreLocation {

    private Long id;
    private String locationName;
    private Set<Sale> salesInStore;

    public StoreLocation() {  }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "location_name")
    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    @Column(name = "sales_in_store")
    @OneToMany(mappedBy = "storeLocation")
    public Set<Sale> getSalesInStore() {
        return salesInStore;
    }

    public void setSalesInStore(Set<Sale> salesInStore) {
        this.salesInStore = salesInStore;
    }
}
