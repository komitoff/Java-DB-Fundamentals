package app.serviceImpl;

import app.domain.dto.json.CategoryJsonDto;
import app.domain.model.Category;
import app.io.ModelParser;
import app.repository.impl.CategoryRepository;
import app.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void save(CategoryJsonDto categoryJsonDto) {
        Category cat = ModelParser.getInstance().map(categoryJsonDto, Category.class);
        this.categoryRepository.save(cat);
    }
}
