package application.repository;

import application.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM user AS u WHERE u.email LIKE %?1",
    nativeQuery = true)
    List<User> findByEmail(String provider);
}
