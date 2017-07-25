package student_system.terminal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import student_system.entity.Course;
import student_system.entity.Student;
import student_system.repository.CourseRepository;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

@Component
public class ConsoleRunner implements CommandLineRunner {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private Calendar calendar;

    @Override
    public void run(String... strings) throws Exception {
        seedData();
    }

    public void seedData() {
        addNewCourse();
    }

    public void addNewCourse() {
        Course course = new Course();
        course.setName("Math");
        course.setDescription("Simple mathematics");
        calendar.set(2011, 12, 12);
        Date startDate = calendar.getTime();
        calendar.set(2020, 11,23);
        Date endDate = calendar.getTime();
        course.setStartDate(startDate);
        course.setEndDate(endDate);
        course.setPrice(BigDecimal.valueOf(250));
        courseRepository.save(course);
    }

    public void addNewStudent() {
        calendar.set(1991, 12,12);
        Date birthDate = calendar.getTime();
        calendar.set(2015,12,12);
        Date registrationDate = calendar.getTime();

        Student student = new Student();
        student.setName("Ivan");
        student.setPhoneNumber("0898 88 88 88");
        student.setRegistrationDate(registrationDate);
        student.setBirthday(birthDate);

    }

    public void addNewHomework() {

    }

    public void addNewResource() {
        
    }
}
