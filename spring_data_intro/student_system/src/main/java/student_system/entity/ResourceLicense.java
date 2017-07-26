package student_system.entity;

import javax.persistence.*;

@Entity
@Table(name = "resource_license")
public class ResourceLicense {
    private Long id;
    private String name;
    private Resource resource;

    public ResourceLicense() {}

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

    @ManyToOne
    @JoinColumn(name = "resource_id",
    referencedColumnName = "id")
    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }
}
