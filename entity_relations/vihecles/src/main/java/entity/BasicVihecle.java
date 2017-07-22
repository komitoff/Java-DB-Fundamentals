package entity;

import entity.api.Vihecle;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "vihecle")
@Inheritance(strategy = InheritanceType.JOINED)
public class BasicVihecle implements Vihecle {

    private Long id;
    private String manufacturer;
    private String model;
    private BigDecimal price;
    private Double maxSpeed;

    protected BasicVihecle() { }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    @Column(name = "manufacturer")
    public String getManufacturer() {
        return null;
    }

    @Override
    @Column(name = "model")
    public String getModel() {
        return null;
    }

    @Override
    @Column(name = "price")
    public BigDecimal getPrice() {
        return null;
    }

    @Override
    @Column(name = "max_speed")
    public Double getMaxSpeed() {
        return null;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setMaxSpeed(Double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
