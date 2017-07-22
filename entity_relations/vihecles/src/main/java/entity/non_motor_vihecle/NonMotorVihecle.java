package entity.non_motor_vihecle;

import entity.BasicVihecle;

import javax.persistence.*;

@Entity
@Table(name = "non_motor_vihecle")
@PrimaryKeyJoinColumn(referencedColumnName = "id")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class NonMotorVihecle extends BasicVihecle {
    private Integer shiftCount;
    private String color;

    protected NonMotorVihecle() {}

    @Column(name = "shift_count")
    public Integer getShiftCount() {
        return shiftCount;
    }

    public void setShiftCount(Integer shiftCount) {
        this.shiftCount = shiftCount;
    }

    @Column(name = "color")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
