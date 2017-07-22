package entity;

import javafx.print.PageLayout;

import javax.persistence.*;

@Entity
@Table(name = "player")
public class Player {
    private Long id;
    private String name;
    private Integer squadNumber;
    private Team team;
    private Position position;
    private Boolean isInjured;

    public Player() {}

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

    @Column(name = "squad_number")
    public Integer getSquadNumber() {
        return squadNumber;
    }

    public void setSquadNumber(Integer squadNumber) {
        this.squadNumber = squadNumber;
    }

    @ManyToOne
    @JoinColumn(name = "team_id",
    referencedColumnName = "id")
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @ManyToOne
    @JoinColumn(name = "position_id",
    referencedColumnName = "id")
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Column(name = "is_injured")
    public Boolean getInjured() {
        return isInjured;
    }

    public void setInjured(Boolean injured) {
        isInjured = injured;
    }
}
