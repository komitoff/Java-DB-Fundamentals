package app.domain.dto.json;

import com.google.gson.annotations.Expose;

public class CategoryJsonDto {
    @Expose
    private String name;

    public CategoryJsonDto() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
