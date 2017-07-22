package entity.motor_vihecle;

import entity.motor_vihecle.MotorVihecle;

import javax.persistence.*;

@Entity
@Table(name = "ship")
public abstract class Ship extends MotorVihecle {
    private String nationality;
    private String captain;
    private Double sizeOfShipCrew;

    protected Ship() {}

    @Column(name = "nationality")
    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Column(name = "captain_name")
    public String getCaptain() {
        return captain;
    }

    public void setCaptain(String captain) {
        this.captain = captain;
    }

    @Column(name = "size_of_ship_crew")
    public Double getSizeOfShipCrew() {
        return sizeOfShipCrew;
    }

    public void setSizeOfShipCrew(Double sizeOfShipCrew) {
        this.sizeOfShipCrew = sizeOfShipCrew;
    }
}
