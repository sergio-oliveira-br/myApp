package com.alucontrol.backendv1.Controllers.Rent;

import com.alucontrol.backendv1.Model.Rent;
import com.alucontrol.backendv1.Service.RentServices;
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
        return rentServices.saveRentChanges(rent, id);
    }
}
