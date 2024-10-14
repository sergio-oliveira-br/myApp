package com.alucontrol.backendv1.Service.RentStatus;

import com.alucontrol.backendv1.Model.Rent;

public interface RentStatusHandler {

    void handleRentStatusUpdate (Rent rent);
}
