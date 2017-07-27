package app.service.impl;

import app.dao.api.CategoriesDao;
import app.entities.Category;
import app.service.api.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService<Category, Long> {

    @Autowired
    private CategoriesDao categoriesDao;

    @Override
    public void save(Category category) {
        categoriesDao.save(category);
    }

    @Override
    public Category findByName(String name) {
        return categoriesDao.findByName(name);
    }
}
