package entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@DiscriminatorValue(value = "teacher")
public class Teacher extends BasicPerson{
    private String email;
    private BigDecimal salaryPerHour;
    private Set<Student> students;
    private Set<Course> courses;

    public Teacher() {}

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "salary_per_hour")
    public BigDecimal getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(BigDecimal salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    @ManyToMany
    @JoinColumn(name = "student_id",
    referencedColumnName = "id")
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @OneToMany(mappedBy = "teacher")
    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
