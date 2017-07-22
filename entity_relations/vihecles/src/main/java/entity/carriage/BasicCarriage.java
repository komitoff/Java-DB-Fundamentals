package entity.carriage;

import entity.api.Carriage;

import javax.persistence.*;

@Entity
@Table(name = "carriage")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public class BasicCarriage implements Carriage{
    private Long id;
    private Integer passengersSeatCapacity;

    protected BasicCarriage() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    @Column(name = "passengers_seat_capacity")
    public Integer getPassengersSeatCapacity() {
        return passengersSeatCapacity;
    }

    private void setPassengersSeatCapacity(Integer passengersSeatCapacity) {
        this.passengersSeatCapacity = passengersSeatCapacity;
    }
}
