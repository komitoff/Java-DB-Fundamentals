package entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "continent")
public class Continent {
    private Long id;
    private String name;
    private Set<Country> countries;

    public Continent() {}

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

    @ManyToMany
    @JoinColumn(name = "country_id",
    referencedColumnName = "id")
    public Set<Country> getCountries() {
        return countries;
    }

    public void setCountries(Set<Country> countries) {
        this.countries = countries;
    }
}
