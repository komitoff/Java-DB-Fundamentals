package app.terminal;

import app.domain.dto.binding.CategoryDto;
import app.domain.dto.binding.UserDto;
import app.domain.dto.binding.add.CategoryAddDto;
import app.domain.dto.binding.add.ProductAddDto;
import app.domain.dto.binding.add.UserAddDto;
import app.io.JsonParser;
import app.service.CategoryService;
import app.service.ProductService;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

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
        this.importCategories();
        this.importProducts();
    }

    public void importUsers() {
        try {
            UserAddDto[] users = this.jsonParser.
                    importJson(UserAddDto[].class, "/files/input/json/users.json");
            for (UserAddDto ujd : users) {
                this.userService.save(ujd);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void importCategories() {
        try {
            CategoryAddDto[] categories = this.jsonParser.
                    importJson(CategoryAddDto[].class, "/files/input/json/categories.json");
            for (CategoryAddDto cat : categories) {
                this.categoryService.save(cat);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void importProducts() {
        Random random = new Random();
        List<UserDto> users = this.userService.findAll();
        List<CategoryDto> categories = this.categoryService.findAll();
        int count = 0;
        try {
            ProductAddDto[] products = this.jsonParser.
                    importJson(ProductAddDto[].class, "/files/input/json/products.json");
            for (ProductAddDto product : products) {
                Set<CategoryDto> categoryDtoSet = new HashSet<>();
                UserDto buyer = users.get(random.nextInt(users.size()));
                UserDto seller = users.get(random.nextInt(users.size()));

//                if (buyer.getId().equals(seller.getId()) || count % 10 == 0) {
//                    buyer = null;
//                }
                int len = random.nextInt(10);
                for (int i = 0; i < len; i++) {
                    categoryDtoSet.add(categories.get(random.nextInt(categories.size())));

                }
                product.setCategories(categoryDtoSet);
                product.setSellerId(seller);
                product.setBayerId(buyer);
                this.productService.save(product);
                count ++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
