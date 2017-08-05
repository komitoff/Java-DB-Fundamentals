package app.service;

import app.domain.dto.json.ProductJsonDto;

public interface ProductService {
    void save(ProductJsonDto productJsonDto);
}
