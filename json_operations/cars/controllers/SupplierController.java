package cars.controllers;

import cars.dto.bindings.SupplierImportDto;
import cars.dto.views.LocalSupplierViewDto;
import cars.serializers.JsonSerializer;
import cars.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Arrays;
import java.util.List;



@Controller
public class SupplierController {
    private static final String SUPPLIERS_JASON_PATH = "/json/input/suppliers.json";
    private static final String LOCAL_SUPPLIERS_PATH = "/src/main/resources/json/output/local-suppliers.json";

    private final SupplierService supplierService;
    private final JsonSerializer jsonSerializer;

    @Autowired
    public SupplierController(SupplierService supplierService, JsonSerializer jsonSerializer) {
        this.supplierService = supplierService;
        this.jsonSerializer = jsonSerializer;
    }

    public void importSuppliers() {
        SupplierImportDto[] supplierImportDtos = this.jsonSerializer.deserialize(SupplierImportDto[].class, SUPPLIERS_JASON_PATH);
        this.supplierService.createMany(Arrays.asList(supplierImportDtos));
    }

    public void exportLocalSuppliers() {
        List<LocalSupplierViewDto> localSuppliers = this.supplierService.getLocalSuppliers();
        this.jsonSerializer.serialize(localSuppliers, LOCAL_SUPPLIERS_PATH);
    }
}
