package com.alucontrol.backendv1.service.rentstatus;

import com.alucontrol.backendv1.model.Rent;
import com.alucontrol.backendv1.service.inventory.DecreaseStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("Em andamento")
public class InProgressRentHandler implements RentStatusHandler {

    private final DecreaseStockService decreaseStockService;

    @Autowired
    public InProgressRentHandler(DecreaseStockService decreaseStockService) {
        this.decreaseStockService = decreaseStockService;
    }

    @Override
    public void handleRentStatusUpdate (Rent rent) {
        String product = rent.getRentItem();
        int productQty = rent.getRentQtyItem();
        
        decreaseStockService.decreaseStock(product, productQty);
    }
}
