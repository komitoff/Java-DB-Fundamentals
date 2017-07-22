package entity.motor_vihecle;

import entity.motor_vihecle.MotorVihecle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "car")
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class Car extends MotorVihecle {
    private Integer numberOfDoors;
    private Boolean havingInsurance;

    public Car() {}

    @Column(name = "number_of_doors")
    public Integer getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(Integer numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    @Column(name = "having_insurance")
    public Boolean getHavingInsurance() {
        return havingInsurance;
    }

    public void setHavingInsurance(Boolean havingInsurance) {
        this.havingInsurance = havingInsurance;
    }
}
