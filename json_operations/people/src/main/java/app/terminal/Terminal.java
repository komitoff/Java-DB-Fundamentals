package app.terminal;

import app.domain.dto.json.CategoryJsonDto;
import app.domain.dto.json.ProductJsonDto;
import app.domain.dto.json.UserJsonDto;
import app.io.JsonParser;
import app.service.CategoryService;
import app.service.ProductService;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Terminal implements CommandLineRunner {

    private UserService userService;
    private ProductService productService;
    private CategoryService categoryService;
    private JsonParser jsonParser;

    @Autowired
    public Terminal(UserService userService, ProductService productService,
                    CategoryService categoryService, JsonParser jsonParser) {
        this.userService = userService;
        this.productService = productService;
        this.categoryService = categoryService;
        this.jsonParser = jsonParser;
    }

    @Override
    public void run(String... strings) throws Exception {
        this.importUsers();
        this.importProducts();
  //      this.importCategories();
    }

    public void importUsers() {
        try {
            UserJsonDto[] users = this.jsonParser.
                    importJson(UserJsonDto[].class, "/files/input/json/users.json");
            for (UserJsonDto ujd : users) {
                this.userService.save(ujd);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void importCategories() {
        try {
            CategoryJsonDto[] categories = this.jsonParser.
                    importJson(CategoryJsonDto[].class, "/files/input/json/categories.json");
            for (CategoryJsonDto cat : categories) {
                this.categoryService.save(cat);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void importProducts() {
        try {
            ProductJsonDto[] products = this.jsonParser.
                    importJson(ProductJsonDto[].class, "/files/input/json/products.json");
            for (ProductJsonDto product : products) {
                this.productService.save(product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
