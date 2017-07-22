package entity.motor_vihecle;

import entity.motor_vihecle.MotorVihecle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "train")
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class Train extends MotorVihecle {
    private String locomotive;
    private Integer numberOfCarriages;
    private String listOfCarriages;

    public Train () {}

    @Column(name = "locomotive")
    public String getLocomotive() {
        return locomotive;
    }

    public void setLocomotive(String locomotive) {
        this.locomotive = locomotive;
    }

    @Column(name = "number_of_carriages")
    public Integer getNumberOfCarriages() {
        return numberOfCarriages;
    }

    public void setNumberOfCarriages(Integer numberOfCarriages) {
        this.numberOfCarriages = numberOfCarriages;
    }

    @Column(name = "list_of_carriages")
    public String getListOfCarriages() {
        return listOfCarriages;
    }

    public void setListOfCarriages(String listOfCarriages) {
        this.listOfCarriages = listOfCarriages;
    }
}
