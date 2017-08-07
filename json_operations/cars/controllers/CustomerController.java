package cars.controllers;

import cars.dto.bindings.CustomerImportDto;
import cars.dto.views.CustomerTotalSalesViewDto;
import cars.dto.views.OrderedCustomersViewDto;
import cars.serializers.JsonSerializer;
import cars.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Arrays;
import java.util.List;


@Controller
public class CustomerController {
    private static final String CUSTOMERS_INPUT_JASON_PATH = "/json/input/customers.json";
    private static final String ORDERED_CUSTOMERS_PATH = "/src/main/resources/json/output/ordered-customers.json";
    private static final String CUSTOMERS__TOTAL_SALES_PATH = "/src/main/resources/json/output/customers-total-sales.json";

    private final CustomerService customerService;
    private final JsonSerializer jsonSerializer;

    @Autowired
    public CustomerController(CustomerService customerService, JsonSerializer jsonSerializer) {
        this.customerService = customerService;
        this.jsonSerializer = jsonSerializer;
    }

    public void importCustomers() {
        CustomerImportDto[] customerImportDtos = this.jsonSerializer.deserialize(CustomerImportDto[].class, CUSTOMERS_INPUT_JASON_PATH);
        this.customerService.createMany(Arrays.asList(customerImportDtos));
    }

    public void exportOrderedCustomers() {
        List<OrderedCustomersViewDto> orderedCustomersViewDtos = this.customerService.orderedCustomers();
        this.jsonSerializer.serialize(orderedCustomersViewDtos, ORDERED_CUSTOMERS_PATH);
    }

    public void exportTotalSalesByCustomer() {
        List<CustomerTotalSalesViewDto> customerTotalSalesViewDtos = this.customerService.getTotalSalesByCustomer();
        this.jsonSerializer.serialize(customerTotalSalesViewDtos, CUSTOMERS__TOTAL_SALES_PATH);
    }
}
