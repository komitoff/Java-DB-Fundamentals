package app.dao.api;


import app.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesDao extends JpaRepository<Category, Long> {

    Category findByName(String name);
}
