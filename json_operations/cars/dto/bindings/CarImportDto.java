package cars.dto.bindings;

import cars.dto.utilities.PartIdDto;
import com.google.gson.annotations.Expose;

import java.util.Set;


public class CarImportDto {

    @Expose
    private String make;

    @Expose
    private String model;

    @Expose
    private long travelledDistance;

    private Set<PartIdDto> parts;

    public CarImportDto() {
    }

    public String getMake() {
        return this.make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getTravelledDistance() {
        return this.travelledDistance;
    }

    public void setTravelledDistance(long travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public Set<PartIdDto> getParts() {
        return this.parts;
    }

    public void setParts(Set<PartIdDto> parts) {
        this.parts = parts;
    }
}
