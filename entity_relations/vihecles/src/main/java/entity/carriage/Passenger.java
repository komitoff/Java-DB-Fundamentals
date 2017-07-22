package entity.carriage;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "passenger")
public class Passenger extends BasicCarriage {
    private Integer standingPassengersCapacity;

    public Passenger() {}

    public Integer getStandingPassengersCapacity() {
        return standingPassengersCapacity;
    }

    public void setStandingPassengersCapacity(Integer standingPassengersCapacity) {
        this.standingPassengersCapacity = standingPassengersCapacity;
    }
}
