package cars.controllers;

import cars.dto.views.SaleInfoViewDto;
import cars.serializers.JsonSerializer;
import cars.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
public class SaleController {
    private static final String SALES_DISCOUNTS_CARS_PATH = "/src/main/resources/json/output/sales-discounts.json";

    private final SaleService saleService;
    private final JsonSerializer jsonSerializer;

    @Autowired
    public SaleController(SaleService saleService, JsonSerializer jsonSerializer) {
        this.saleService = saleService;
        this.jsonSerializer = jsonSerializer;
    }

    public void importSales() {
        this.saleService.createMany();
    }

    public void exportSalesWithAppliedDiscounts() {
        List<SaleInfoViewDto> salesWithAppliedDiscount = this.saleService.getSalesWithAppliedDiscount();
        this.jsonSerializer.serialize(salesWithAppliedDiscount, SALES_DISCOUNTS_CARS_PATH);
    }
}
