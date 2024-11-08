package com.alucontrol.backendv1.service.rentstatus;

import com.alucontrol.backendv1.model.Rent;
import com.alucontrol.backendv1.service.inventory.ReturnStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("Encerrado")
public class ClosedRentHandler implements RentStatusHandler {

    private final ReturnStockService returnStockService;

    @Autowired
    public ClosedRentHandler(ReturnStockService returnStockService) {
        this.returnStockService = returnStockService;
    }

    @Override
    public void handleRentStatusUpdate (Rent rent) {

        String product = rent.getRentItem();
        int productQty = rent.getRentQtyItem();

        returnStockService.returnStockAfterRental(product, productQty);
    }
}
