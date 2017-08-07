package cars.repositories;

import cars.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "SELECT c.* FROM all_tasks_db.customers AS c ORDER BY c.birth_date ASC, c.is_young_driver ASC", nativeQuery = true)
    List<Customer> getCustomersByOrderByBirthDateAscYoungDriverAsc();

    @Query(value = "SELECT DISTINCT c.* FROM all_tasks_db.customers AS c INNER JOIN all_tasks_db.sales AS s ON c.customer_id = s.customer_id", nativeQuery = true)
    List<Customer> getCustomersByBoughtCars();
}
