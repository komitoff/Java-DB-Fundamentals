package entity.motor_vihecle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "cruise_ship")
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class CruiseShip extends Ship{
    private Integer passengerCapacity;

    public CruiseShip() {}

    @Column(name = "passengers_capacity")
    public Integer getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(Integer passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }
}
