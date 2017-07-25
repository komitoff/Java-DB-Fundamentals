package student_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import student_system.entity.Homework;

@Repository
public interface HomeworkRepository extends JpaRepository<Homework, Long> {
}
