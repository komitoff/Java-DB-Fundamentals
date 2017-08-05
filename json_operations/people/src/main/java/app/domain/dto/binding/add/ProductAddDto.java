package app.domain.dto.binding.add;

import app.domain.dto.binding.CategoryDto;
import app.domain.dto.binding.UserDto;
import app.domain.model.Category;
import app.domain.model.User;
import com.google.gson.annotations.Expose;

import java.math.BigDecimal;
import java.util.Set;

public class ProductAddDto {
    @Expose
    private String name;
    @Expose
    private BigDecimal price;

    private UserDto bayerId;
    private UserDto sellerId;
    private Set<CategoryDto> categories;

    public ProductAddDto() {    }

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

    public UserDto getBayerId() {
        return bayerId;
    }

    public void setBayerId(UserDto bayerId) {
        this.bayerId = bayerId;
    }

    public UserDto getSellerId() {
        return sellerId;
    }

    public void setSellerId(UserDto sellerId) {
        this.sellerId = sellerId;
    }

    public Set<CategoryDto> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoryDto> categories) {
        this.categories = categories;
    }
}
