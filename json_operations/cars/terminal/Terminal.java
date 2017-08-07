package cars.terminal;

import cars.controllers.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Terminal implements CommandLineRunner {

    private final SupplierController supplierController;
    private final PartController partController;
    private final CarController carController;
    private final CustomerController customerController;
    private final SaleController saleController;

    @Autowired
    public Terminal(SupplierController supplierController, PartController partController, CarController carController, CustomerController customerController, SaleController saleController) {
        this.supplierController = supplierController;
        this.partController = partController;
        this.carController = carController;
        this.customerController = customerController;
        this.saleController = saleController;
    }

    @Override
    public void run(String... strings) throws Exception {
//        this.supplierController.importSuppliers();
//        this.partController.importParts();
//        this.carController.importCars();
//        this.customerController.importCustomers();
//        this.saleController.importSales();

        this.customerController.exportOrderedCustomers();
        this.carController.exportToyotaCars();
        this.supplierController.exportLocalSuppliers();
        this.carController.exportCarsWithParts();
        this.saleController.exportSalesWithAppliedDiscounts();
        this.customerController.exportTotalSalesByCustomer();
    }
}
