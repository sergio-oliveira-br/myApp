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

        List<Rent> allRentsFound = rentServices.findAllRents();

        return ResponseEntity.ok(allRentsFound);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rent> getRentById(@PathVariable Long id) {

        Rent rentFound = rentServices.findRentById(id);

        return ResponseEntity.ok(rentFound);
    }

    @GetMapping("/rent-by-date")
    public ResponseEntity<List<Rent>> getRentByDate(String year, String month) {

        List<Rent> rentsFound = rentServices.findRentByDate(year, month);

        return ResponseEntity.ok(rentsFound);
    }

    @GetMapping("/rent-by-name")
    public ResponseEntity<List<Rent>> getRentByName(String customerName) {

        List<Rent> rentsFound = rentServices.findRentByName(customerName);

        return ResponseEntity.ok(rentsFound);
    }

    @GetMapping("/rent-by-payment-status")
    public ResponseEntity<List<Rent>> getRentByPaymentStatus(String paymentStatus) {

        List<Rent> rentsFound = rentServices.findRentByPaymentStatus(paymentStatus);

        return ResponseEntity.ok(rentsFound);
    }

    @GetMapping("/rent-by-status")
    public ResponseEntity<List<Rent>> getRentByStatus(String rentStatus) {
        return rentServices.findRentByStatus(rentStatus);
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
