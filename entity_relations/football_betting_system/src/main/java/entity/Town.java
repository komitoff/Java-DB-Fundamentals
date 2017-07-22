package entity;

import com.sun.istack.internal.NotNull;
import com.sun.xml.internal.bind.v2.model.core.ID;

import javax.persistence.*;

@Entity
@Table(name = "town")
public class Town {
    private Long id;
    private String name;
    private Country country;

    public Town() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    @NotNull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(name = "country_id",
    referencedColumnName = "id")
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
