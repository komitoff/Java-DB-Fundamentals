package student_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import student_system.entity.Resource;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {
}
