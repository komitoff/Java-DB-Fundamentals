package app.service.api;

public interface CategoryService<Category, Long> {

    void save(Category category);

    Category findByName(String name);
}
