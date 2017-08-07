package cars.dto.bindings;

import cars.dto.utilities.SupplierIdDto;
import com.google.gson.annotations.Expose;

import java.math.BigDecimal;


public class PartImportDto {

    @Expose
    private String name;

    @Expose
    private BigDecimal price;

    @Expose
    private int quantity;

    private SupplierIdDto supplier;

    public PartImportDto() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public SupplierIdDto getSupplier() {
        return this.supplier;
    }

    public void setSupplier(SupplierIdDto supplier) {
        this.supplier = supplier;
    }
}
