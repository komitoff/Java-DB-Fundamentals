package cars.dto.views;

import com.google.gson.annotations.Expose;

import java.util.Set;

/**
 * Created by Hristo Skipernov on 02/08/2017.
 */

public class CarViewAllInfoDto {

    @Expose
    private String make;

    @Expose
    private String model;

    @Expose
    private long travelledDistance;

    private Set<PartViewDto> parts;

    public CarViewAllInfoDto() {
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

    public Set<PartViewDto> getParts() {
        return this.parts;
    }

    public void setParts(Set<PartViewDto> parts) {
        this.parts = parts;
    }
}
