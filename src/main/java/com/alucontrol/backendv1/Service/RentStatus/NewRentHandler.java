package com.alucontrol.backendv1.Service.RentStatus;

import com.alucontrol.backendv1.Model.Rent;
import com.alucontrol.backendv1.Util.LoggerUtil;
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
