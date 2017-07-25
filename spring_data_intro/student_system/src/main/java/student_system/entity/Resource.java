package student_system.entity;

import javax.persistence.*;

@Entity
@Table(name = "resource")
public class Resource {
    private Long id;
    private String name;
    private Enum resourceType;
    private String url;
    private Course course;

    public Resource() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "resource_type")
    public Enum getResourceType() {
        return resourceType;
    }

    public void setResourceType(Enum resourceType) {
        this.resourceType = resourceType;
    }

    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @ManyToOne
    @JoinColumn(name = "course_id",
    referencedColumnName = "id",
    foreignKey = @ForeignKey(name = "FK_resource_id_course"))
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", resourceType=" + resourceType +
                ", url='" + url + '\'' +
                ", course=" + course +
                '}';
    }
}
