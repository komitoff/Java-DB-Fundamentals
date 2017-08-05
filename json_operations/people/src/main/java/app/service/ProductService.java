package app.service;

import app.domain.dto.binding.add.ProductAddDto;

public interface ProductService {
    void save(ProductAddDto productJsonDto);
}
