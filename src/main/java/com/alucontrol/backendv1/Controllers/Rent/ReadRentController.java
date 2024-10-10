package com.alucontrol.backendv1.Controllers.Rent;

import com.alucontrol.backendv1.Model.Rent;
import com.alucontrol.backendv1.Service.RentServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rent")
public class ReadRentController {

    private final RentServices rentServices;

    public ReadRentController(RentServices rentServices) {
        this.rentServices = rentServices;
    }


    @GetMapping
    public ResponseEntity<List<Rent>> getAllRent() {
        return rentServices.findAllRents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rent> getRentById(@PathVariable Long id) {
        return rentServices.findRentById(id);
    }

    @GetMapping("/rent-by-date")
    public ResponseEntity<List<Rent>> getRentByDate(String year, String month) {
        return rentServices.findRentByDate(year, month);
    }

    @GetMapping("/rent-by-name")
    public ResponseEntity<List<Rent>> getRentByName(String customerName) {
        return rentServices.findRentByName(customerName);
    }

    @GetMapping("/rent-by-payment-status")
    public ResponseEntity<List<Rent>> getRentByPaymentStatus(String paymentStatus) {
        return rentServices.findRentByPaymentStatus(paymentStatus);
    }

    @GetMapping("/qty/rent-by-status")
    public ResponseEntity<Long> getRentQtyByStatus(String status) {
        return rentServices.findQtyRentByRentStatus(status);
    }

    @GetMapping("/qty/rent-by-payment-status")
    public ResponseEntity<Long> getRentQtyByPaymentStatus(String paymentStatus) {
        return rentServices.findQtyRentByPaymentStatus(paymentStatus);
    }

}
