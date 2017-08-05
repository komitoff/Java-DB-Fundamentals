package app.service;

import app.domain.dto.json.CategoryJsonDto;

public interface CategoryService {
    void save(CategoryJsonDto categoryJsonDto);
}
