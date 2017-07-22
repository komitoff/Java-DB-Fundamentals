package entity.carriage;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "sleeping")
public class Sleeping extends BasicCarriage {
    private Integer bedsCount;

    public Sleeping() {}

    public Integer getBedsCount() {
        return bedsCount;
    }

    public void setBedsCount(Integer bedsCount) {
        this.bedsCount = bedsCount;
    }
}
