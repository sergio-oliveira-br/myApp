package com.alucontrol.backendv1.service.rentstatus;

import com.alucontrol.backendv1.model.Rent;

public interface RentStatusHandler {

    void handleRentStatusUpdate (Rent rent);
}
