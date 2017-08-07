package cars.dto.views;

import cars.dto.utilities.PartPriceUtilityDto;
import com.google.gson.annotations.Expose;

import java.util.Set;

public class SaleInfoViewDto {

    @Expose
    private CarViewDto car;

    @Expose
    private String customerName;

    @Expose
    private double discount;

    private Set<PartPriceUtilityDto> carParts;

    @Expose
    private double price;

    @Expose
    private double priceWithDiscount;

    public SaleInfoViewDto() {
    }

    public CarViewDto getCar() {
        return this.car;
    }

    public void setCar(CarViewDto car) {
        this.car = car;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getDiscount() {
        return this.discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
        this.setPriceWithDiscount(price - (price * this.discount));
    }

    public Set<PartPriceUtilityDto> getCarParts() {
        return this.carParts;
    }

    public void setCarParts(Set<PartPriceUtilityDto> carParts) {
        this.carParts = carParts;
        double price = carParts.stream().mapToDouble(PartPriceUtilityDto::getPrice).sum();
        this.setPrice(price);
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPriceWithDiscount() {
        return this.priceWithDiscount;
    }

    public void setPriceWithDiscount(double priceWithDiscount) {
        this.priceWithDiscount = priceWithDiscount;
    }
}
