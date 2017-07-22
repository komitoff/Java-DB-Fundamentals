package entity.carriage;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.sql.ResultSet;

@Entity
@DiscriminatorValue(value = "restaurant")
public class Restaurant extends BasicCarriage {
    private Integer tablesCount;

    public Restaurant() {}

    public Integer getTablesCount() {
        return tablesCount;
    }

    public void setTablesCount(Integer tablesCount) {
        this.tablesCount = tablesCount;
    }
}
