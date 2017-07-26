package student_system.terminal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import student_system.entity.Course;
import student_system.entity.Homework;
import student_system.entity.Resource;
import student_system.entity.Student;
import student_system.entity.helper.ContentType;
import student_system.entity.helper.ResourceType;
import student_system.repository.CourseRepository;
import student_system.repository.HomeworkRepository;
import student_system.repository.ResourceRepository;
import student_system.repository.StudentRepository;
import student_system.service.StudentService;

import java.awt.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.List;

@Component
public class ConsoleRunner implements CommandLineRunner {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private HomeworkRepository homeworkRepository;
    @Autowired
    private ResourceRepository resourceRepository;

    private Calendar calendar = Calendar.getInstance();

    @Override
    public void run(String... strings) throws Exception {
        seedData();
    }

    public void seedData() {
//        addNewCourse();
//        addNewStudent();
//        addNewHomework();
//        addNewResource();
        //task 7
        List<Student> allStudents = studentRepository.findAll();
        for (Student student : allStudents) {
            System.out.println(student.getName());
            List<Homework> submissions = homeworkRepository.findByStudent(student);
            for (Homework submission : submissions) {
                System.out.println(submission.getContent());
                System.out.println(submission.getContentType());
            }
        }

        List<Course> allCourses = courseRepository.findAll();
        for (Course course : allCourses) {
            List<Resource> resources = resourceRepository.findByCourse(course);
            System.out.println(course.getName());
            resources.forEach(System.out::println);

        }
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
        List<Course> listStudentCourses = courseRepository.findAll();
        Set<Course> studentCourses = new HashSet<>(listStudentCourses);
        student.setCourses(studentCourses);
        studentRepository.saveAndFlush(student);
    }

    public void addNewHomework() {
        Homework homework = new Homework();
        homework.setContent("First submission ever");
        homework.setContentType(ContentType.PDF);
        Student student = studentRepository.findOne(1l);
        List<Course> listStudentCourses = courseRepository.findAll();
        Set<Course> studentCourses = new HashSet<>(listStudentCourses);
        Date submissionDate = calendar.getTime();
        homework.setSubmissionDate(submissionDate);
        student.setCourses(studentCourses);
        homework.setStudent(student);
        homework.setCourses(listStudentCourses.get(0));
        homeworkRepository.saveAndFlush(homework);
    }

    public void addNewResource() {
        Resource resource = new Resource();
        resource.setName("Nakov Book");
        resource.setUrl("www.introprograming.org");
        resource.setResourceType(ResourceType.BOOK);
        Course course = courseRepository.findOne(1l);
        resource.setCourse(course);
        resourceRepository.saveAndFlush(resource);
    }
}
