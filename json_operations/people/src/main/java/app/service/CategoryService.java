package app.service;

import app.domain.dto.binding.CategoryDto;
import app.domain.dto.binding.add.CategoryAddDto;

import java.util.List;

public interface CategoryService {
    void save(CategoryAddDto categoryJsonDto);
    List<CategoryDto> findAll();
}
