package com.alucontrol.backendv1.controllers.rent;

import com.alucontrol.backendv1.service.RentServices;
import com.alucontrol.backendv1.model.Rent;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/rent")
public class CreateRentController {

    private final RentServices rentServices;

    public CreateRentController(RentServices rentServices) {
        this.rentServices = rentServices;
    }

    @PostMapping("/create-rent")
    public ResponseEntity<Rent> createRent (@RequestBody Rent rent) {

        Rent newRent = rentServices.saveRent(rent);

        return ResponseEntity.status(HttpStatus.CREATED).body(newRent);
    }
}
