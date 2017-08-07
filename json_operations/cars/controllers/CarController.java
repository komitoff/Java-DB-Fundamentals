package cars.controllers;

import cars.dto.bindings.CarImportDto;
import cars.dto.views.CarToyotaViewDto;
import cars.dto.views.CarWithPartsViewDto;
import cars.serializers.JsonSerializer;
import cars.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Arrays;
import java.util.List;



@Controller
public class CarController {
    private static final String CARS_JASON_PATH = "/json/input/cars.json";
    private static final String TOYOTA_CARS_PATH = "/src/main/resources/json/output/toyota-cars.json";
    private static final String CARS_AND_PARTS_PATH = "/src/main/resources/json/output/cars-and-parts.json";

    private final CarService carService;
    private final JsonSerializer jsonSerializer;

    @Autowired
    public CarController(CarService carService, JsonSerializer jsonSerializer) {
        this.carService = carService;
        this.jsonSerializer = jsonSerializer;
    }

    public void importCars() {
        CarImportDto[] carImportDtos = this.jsonSerializer.deserialize(CarImportDto[].class, CARS_JASON_PATH);
        this.carService.createMany(Arrays.asList(carImportDtos));
    }

    public void exportToyotaCars() {
        List<CarToyotaViewDto> carToyotaViewDtos = this.carService.getCarsFromMakeToyota("Toyota");
        this.jsonSerializer.serialize(carToyotaViewDtos, TOYOTA_CARS_PATH);
    }

    public void exportCarsWithParts() {
        List<CarWithPartsViewDto> carWithPartsViewDtos = this.carService.getCarsWithParts();
        this.jsonSerializer.serialize(carWithPartsViewDtos, CARS_AND_PARTS_PATH);
    }
}
