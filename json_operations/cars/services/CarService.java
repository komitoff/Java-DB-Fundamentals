package cars.services;

import cars.dto.bindings.CarImportDto;
import cars.dto.views.CarToyotaViewDto;
import cars.dto.views.CarWithPartsViewDto;
import cars.entities.Car;

import java.util.List;

public interface CarService {

    List<Car> findAll();

    Car findById(long id);

    List<CarToyotaViewDto> getCarsFromMakeToyota(String make);

    List<CarWithPartsViewDto> getCarsWithParts();

    Car createOne(Car car);

    List<Car> createMany(List<CarImportDto> carImportDtos);

    Car updateOne(Car car);

    List<Car> updateMany(Iterable<Car> cars);

    void deleteById(long id);

    void deleteByCar(Car car);
}
