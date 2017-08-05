package app.serviceImpl;

import app.domain.dto.json.ProductJsonDto;
import app.domain.model.Product;
import app.io.ModelParser;
import app.repository.impl.ProductRepository;
import app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void save(ProductJsonDto productJsonDto) {
        Product product = ModelParser.getInstance().map(productJsonDto, Product.class);
        this.productRepository.save(product);
    }
}
