package cars.dto.views;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.Set;


public class OrderedCustomersViewDto {

    @Expose
    @SerializedName("Id")
    private long id;

    @Expose
    @SerializedName("Name")
    private String name;

    @Expose
    @SerializedName("BirthDate")
    private Date birthDate;

    @Expose
    @SerializedName("IsYoungDriver")
    private boolean isYoungDriver;

    @Expose
    @SerializedName("Sales")
    private Set<OrderedCustomersSaleView> sales;

    public OrderedCustomersViewDto() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isYoungDriver() {
        return this.isYoungDriver;
    }

    public void setYoungDriver(boolean youngDriver) {
        isYoungDriver = youngDriver;
    }

    public Set<OrderedCustomersSaleView> getSales() {
        return this.sales;
    }

    public void setSales(Set<OrderedCustomersSaleView> sales) {
        this.sales = sales;
    }
}
