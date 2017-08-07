package cars.controllers;

import cars.dto.bindings.PartImportDto;
import cars.serializers.JsonSerializer;
import cars.services.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Arrays;


@Controller
public class PartController {
    private static final String PARTS_JASON_PATH = "/json/input/parts.json";

    private final PartService partService;
    private final JsonSerializer jsonSerializer;

    @Autowired
    public PartController(PartService partService, JsonSerializer jsonSerializer) {
        this.partService = partService;
        this.jsonSerializer = jsonSerializer;
    }

    public void importParts() {
        PartImportDto[] partImportDtos = this.jsonSerializer.deserialize(PartImportDto[].class, PARTS_JASON_PATH);
        this.partService.createMany(Arrays.asList(partImportDtos));
    }
}
