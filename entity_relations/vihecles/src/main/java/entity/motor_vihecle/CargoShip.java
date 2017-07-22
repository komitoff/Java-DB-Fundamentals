package entity.motor_vihecle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "cargo_ship")
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class CargoShip extends Ship{
    private Double maxLoadKilograms;

    public CargoShip() {}

    @Column(name = "max_load_kilograms")
    public Double getMaxLoadKilograms() {
        return maxLoadKilograms;
    }

    public void setMaxLoadKilograms(Double maxLoadKilograms) {
        this.maxLoadKilograms = maxLoadKilograms;
    }
}
