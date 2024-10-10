package com.alucontrol.backendv1.Controllers.Rent;

import com.alucontrol.backendv1.Exception.ResourceNotFoundException;
import com.alucontrol.backendv1.Model.Rent;
import com.alucontrol.backendv1.Service.RentServices;
import com.alucontrol.backendv1.Util.LoggerUtil;
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
    public ResponseEntity<Long> getRentByStatus(String status) {
        return rentServices.findQtyRentByRentStatus(status);
    }




//
//
//
//
//
//
//
//
//
//
//
//
//    /** Endpoint to get the number (qty) of rent by selecting the payment status
//     * This method is pointing to indexScript.js */
//    @GetMapping("/qtyRentByPaymentStatus")
//    public ResponseEntity<Long> getQtyRentByPaymentStatus(@RequestParam String paymentStatus) {
//        LoggerUtil.info("Fetching Rent Payment Status: " + paymentStatus);
//        Long countRentByPaymentStatus;
//
//        try {
//            countRentByPaymentStatus = rentPaymentStatusRepository.countRentByPaymentStatus(paymentStatus);
//
//            if(countRentByPaymentStatus == null){
//                LoggerUtil.error("No Rent found for payment status: " + paymentStatus);
//                throw new ResourceNotFoundException("No Rent found for payment status: " + paymentStatus);
//
//            }
//        }catch (Exception e){
//            LoggerUtil.error("An error occurred while fetching the quantity of rent by payment status. | " +
//                    "Error: " + e.getMessage(), e);
//
//            throw new ResourceNotFoundException("An error occurred while fetching the quantity of rent by payment status. |" +
//                    "Rent Payment Status: " + paymentStatus +
//                    " | Error: " + e.getMessage() + e);
//        }
//
//        LoggerUtil.debug("Rent Payment Status: " + paymentStatus);
//        return ResponseEntity.ok(countRentByPaymentStatus);
//    }
}
