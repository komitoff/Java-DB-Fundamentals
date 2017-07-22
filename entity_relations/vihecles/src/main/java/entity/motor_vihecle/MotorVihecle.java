package entity.motor_vihecle;

import entity.BasicVihecle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "motor_vihecle")
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public abstract class MotorVihecle extends BasicVihecle {
    private Integer numberOfEngines;
    private String engineType;
    private Double tankCapacity;

    protected MotorVihecle() {}

    @Column(name = "number_of_engines")
    public Integer getNumberOfEngines() {
        return numberOfEngines;
    }

    public void setNumberOfEngines(Integer numberOfEngines) {
        this.numberOfEngines = numberOfEngines;
    }

    @Column(name = "engine_type")
    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    @Column(name = "tank_capacity")
    public Double getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(Double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }
}
