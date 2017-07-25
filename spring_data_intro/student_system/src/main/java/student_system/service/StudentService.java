package student_system.service;

import org.springframework.stereotype.Service;
import student_system.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
}
