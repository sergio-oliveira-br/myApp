package com.alucontrol.backendv1.Controllers.Rent;

import com.alucontrol.backendv1.Service.RentServices;
import com.alucontrol.backendv1.Util.LoggerUtil;
import com.alucontrol.backendv1.Model.Rent;
import com.alucontrol.backendv1.Repository.RentRepository;
import com.alucontrol.backendv1.Service.StockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/rent/create-rent")
public class CreateRentController {

    private final RentRepository rentRepository;
    private final StockService stockService;
    private final RentServices rentServices;

    public CreateRentController(RentRepository rentRepository, StockService stockService, RentServices rentServices) {
        this.rentRepository = rentRepository;
        this.stockService = stockService;
        this.rentServices = rentServices;
    }

    @PostMapping
    public ResponseEntity<Rent> createRent (@RequestBody Rent rent) {
        return rentServices.saveRent(rent);
    }


    /** Endpoint to get a specific rent by ID (by clicking on Edit into the table)*/
    @GetMapping("/rent/{id}")
    public ResponseEntity<Rent> getRentById(@PathVariable Long id) {
        Optional<Rent> rentOptional = rentRepository.findById(id);
        if (rentOptional.isPresent()) {
            return ResponseEntity.ok(rentOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
