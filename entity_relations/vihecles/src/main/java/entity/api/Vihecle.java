package entity.api;

import java.math.BigDecimal;

public interface Vihecle {
    String getManufacturer();
    String getModel();
    BigDecimal getPrice();
    Double getMaxSpeed();
}
