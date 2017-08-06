package app.serviceImpl;

import app.domain.dto.binding.CategoryDto;
import app.domain.dto.binding.add.CategoryAddDto;
import app.domain.model.Category;
import app.io.ModelParser;
import app.repository.impl.CategoryRepository;
import app.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void save(CategoryAddDto categoryJsonDto) {
        Category cat = ModelParser.getInstance().map(categoryJsonDto, Category.class);
        this.categoryRepository.saveAndFlush(cat);
    }

    @Override
    public List<CategoryDto> findAll() {
        List<Category> allCategories = this.categoryRepository.findAll();
        List<CategoryDto> allCategoriesDto = new ArrayList<>();
        for (Category category : allCategories) {
            CategoryDto categoryDto = ModelParser.getInstance().map(category, CategoryDto.class);
            allCategoriesDto.add(categoryDto);
        }

        return allCategoriesDto;
    }
}
