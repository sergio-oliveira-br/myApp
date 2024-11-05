package com.alucontrol.backendv1.service.rentstatus;

import com.alucontrol.backendv1.model.Rent;
import com.alucontrol.backendv1.util.LoggerUtil;
import org.springframework.stereotype.Component;

@Component("Novo")
public class NewRentHandler implements RentStatusHandler {

    @Override
    public void handleRentStatusUpdate(Rent rent) {

        String product = rent.getRentItem();
        String status = rent.getRentStatus();

        LoggerUtil.info("O estoque do produto '" + product + "' não foi alterado, " +
                "devido ao status '" + status + "'. " +
                "Aluguel ID:" + rent.getId());
    }
}
