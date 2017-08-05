package app.serviceImpl;

import app.domain.dto.binding.add.ProductAddDto;
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
    public void save(ProductAddDto productJsonDto) {
        Product product = ModelParser.getInstance().map(productJsonDto, Product.class);
        this.productRepository.saveAndFlush(product);
    }
}
