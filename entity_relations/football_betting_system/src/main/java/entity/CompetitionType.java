package entity;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;

@Entity
@Table(name = "competition_type")
public class CompetitionType {
    private Long id;
    private String type;

    public CompetitionType() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
