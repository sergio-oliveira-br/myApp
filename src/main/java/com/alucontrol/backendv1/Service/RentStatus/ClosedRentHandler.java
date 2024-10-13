package com.alucontrol.backendv1.Service.RentStatus;

import com.alucontrol.backendv1.Model.Rent;
import com.alucontrol.backendv1.Service.Inventory.ReturnStockService;
import com.alucontrol.backendv1.Util.LoggerUtil;
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
        String status = rent.getRentStatus();

        returnStockService.returnStockAfterRental(product, productQty);

        LoggerUtil.info("O estoque do produto '" + product + "' foi retornado em " + productQty + " un " +
                "devido ao status '" + status + "' . " +
                "Aluguel ID:" + rent.getId());
    }
}
