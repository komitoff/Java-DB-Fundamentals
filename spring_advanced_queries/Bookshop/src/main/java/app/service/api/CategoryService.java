package app.service.api;

import app.entities.Category;

public interface CategoryService {

    void save(Category category);

    Category findByName(String name);
}
