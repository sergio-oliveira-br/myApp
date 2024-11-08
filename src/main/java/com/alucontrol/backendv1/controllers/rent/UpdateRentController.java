package com.alucontrol.backendv1.controllers.rent;

import com.alucontrol.backendv1.model.Rent;
import com.alucontrol.backendv1.service.RentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/rent")
public class UpdateRentController {

    private final RentServices rentServices;

    @Autowired
    public UpdateRentController(RentServices rentServices) {
        this.rentServices = rentServices;
    }

    @PutMapping("/update-rent/{id}")
    public ResponseEntity<Rent> updateRent(@RequestBody Rent rent, @PathVariable("id") Long id) {

        Rent updatedRent = rentServices.saveRentChanges(rent, id);

        return ResponseEntity.ok(updatedRent);
    }
}
