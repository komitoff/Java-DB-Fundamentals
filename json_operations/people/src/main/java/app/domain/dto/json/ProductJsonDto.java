package app.domain.dto.json;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class ProductJsonDto {
    @Expose
    private String name;
    @Expose
    private BigDecimal price;

    public ProductJsonDto() {    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
