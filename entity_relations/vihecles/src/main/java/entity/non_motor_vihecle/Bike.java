package entity.non_motor_vihecle;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "bike")
public class Bike extends NonMotorVihecle{

}
