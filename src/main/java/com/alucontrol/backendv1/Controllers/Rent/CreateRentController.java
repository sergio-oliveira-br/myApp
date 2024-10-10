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


    /** Endpoint to update a specific rent by ID */
    @PutMapping("/rent/{id}")
    public ResponseEntity<Rent> updateRent(@PathVariable Long id, @RequestBody Rent updatedRent) {
        LoggerUtil.info("Starting to update rent with data: " + updatedRent.toString());

        Optional<Rent> rentOptional = rentRepository.findById(id);
        if (rentOptional.isPresent()) {

            Rent rent = rentOptional.get();

            rent.setRentFirstName(updatedRent.getRentFirstName());
            //rent.setRentLastName(updatedRent.getRentLastName());
            rent.setRentAddress(updatedRent.getRentAddress());
            rent.setRentItem(updatedRent.getRentItem());
            rent.setRentPrice(updatedRent.getRentPrice());
            rent.setRentQtyItem(updatedRent.getRentQtyItem());
            rent.setRentStarts(updatedRent.getRentStarts());
            rent.setRentEnds(updatedRent.getRentEnds());
            rent.setRentTotalDays(updatedRent.getRentTotalDays());
            rent.setRentTotalPrice(updatedRent.getRentTotalPrice());
            rent.setRentDetails(updatedRent.getRentDetails());
            rent.setRentPaymentStatus(updatedRent.getRentPaymentStatus());
            rent.setRentStatus(updatedRent.getRentStatus());

            if(updatedRent.getRentStatus().equals("Novo")) {
                //Create a log
                LoggerUtil.info("Status: Novo -> Nenhuma alteraçao no estoque foi realizada!");
            }

            else if (updatedRent.getRentStatus().equals("Em andamento")) {
                 //If the status changed from new to in progress, then the stock have to decrease
                stockService.subtractStock(updatedRent.getRentItem(), updatedRent.getRentQtyItem());
            }
            else if (updatedRent.getRentStatus().equals("Encerrado")) {
                //Execute the method to return the qyt to the stock
                stockService.addStockByRentalStatusFinished(updatedRent.getRentItem(), updatedRent.getRentQtyItem());
            }
            Rent savedRent = rentRepository.save(rent);
            LoggerUtil.info("Rent updated: " + savedRent.toString());
            return ResponseEntity.ok(savedRent);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
