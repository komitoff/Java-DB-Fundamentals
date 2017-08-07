package cars.dto.views;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Hristo Skipernov on 03/08/2017.
 */

public class CarToyotaViewDto {

    @Expose
    @SerializedName("Id")
    private long id;

    @Expose
    @SerializedName("Make")
    private String make;

    @Expose
    @SerializedName("Model")
    private String model;

    @Expose
    @SerializedName("TravelledDistance")
    private long travelledDistance;

    public CarToyotaViewDto() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
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
}
