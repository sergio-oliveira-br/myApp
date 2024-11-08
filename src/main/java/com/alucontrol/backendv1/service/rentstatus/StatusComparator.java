package com.alucontrol.backendv1.service.rentstatus;

import com.alucontrol.backendv1.model.Rent;

public class StatusComparator {

    // Este metodo recebe o aluguel existente e o atualizado, e retorna um boolean indicando se o status foi alterado.
    public boolean hasStatusChangedRent (Rent existingRent, Rent updatedRent) {
        return !existingRent.getRentStatus().equals(updatedRent.getRentStatus());
    }
}
