package student_system.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "homework")
public class Homework {
    private Long id;
    private String content;
    private Enum contentType;
    private Date submissionDate;
    private Student student;
    private Course courses;

    public Homework() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column(name = "content_type")
    public Enum getContentType() {
        return contentType;
    }

    public void setContentType(Enum contentType) {
        this.contentType = contentType;
    }

    @Column(name = "submission_date")
    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

    @ManyToOne
    @JoinColumn(name = "student_id",
    referencedColumnName = "id",
    foreignKey = @ForeignKey(name = "FK_homework_student"))
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @ManyToOne
    @JoinColumn(name = "course_id",
    referencedColumnName = "id",
    foreignKey = @ForeignKey(name = "FK_homework_course"))
    public Course getCourses() {
        return courses;
    }

    public void setCourses(Course courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Homework{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", contentType=" + contentType +
                ", submissionDate=" + submissionDate +
                ", student=" + student +
                '}';
    }
}
