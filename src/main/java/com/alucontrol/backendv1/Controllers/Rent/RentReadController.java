/**
 * National College of Ireland - NCI
 *    Higher Diploma in Computing
 *         Final Project
 *              ---
 * Author: Sergio Vinicio da Silva Oliveira
 * ID: x23170981@student.ncirl.ie
 * Project Commencing May 2024
 * Version: 1.0
 */
package com.alucontrol.backendv1.Controllers.Rent;

import com.alucontrol.backendv1.Exception.ResourceNotFoundException;
import com.alucontrol.backendv1.Model.Expense;
import com.alucontrol.backendv1.Model.Rent;
import com.alucontrol.backendv1.Repository.RentRepository;
import com.alucontrol.backendv1.Util.LoggerUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/** This controller is dedicated to endpoints that read data */
@RestController
public class RentReadController
{
    //Repository for access to product data
    private final RentRepository rentRepository;

    //Constructor responsible for injecting the repository
    public RentReadController(RentRepository rentRepository)
    {
        this.rentRepository = rentRepository;
    }

    /** Endpoint to get back all rent */
    @GetMapping("/rent")
    public ResponseEntity<List<Rent>> getAllRent()
    {
        LoggerUtil.info("Fetching all rent records"); //Create log
        List<Rent> rent = rentRepository.findAll(); //using the method findALL from CRUD
        LoggerUtil.info("Fetched " + rent.size() + " rent records"); //Create a log

        //Returning the list of all rent records in a ResponseEntity with status OK
        return ResponseEntity.ok(rent);
    }

    /** Endpoint to retrieve Rent by selecting the "Month" and "Year" in expenseDate field */
    @GetMapping("/rentByDate")
    public ResponseEntity<List<Rent>> getRentByDate(String year, String month)
    {
        List<Rent> rents = rentRepository.findByYearAndMonth(year, month);

        if (rents.isEmpty()) {
            LoggerUtil.error("No Rent found for year " + year + " and month " + month);
            throw new ResourceNotFoundException("No Rent found");
        }
        return ResponseEntity.ok(rents);
    }

    /** Endpoint to retrieve Rent by selecting the Rent Payment Status */
    @GetMapping("/rentByPaymentStatus")
    public ResponseEntity<List<Rent>> getRentByPaymentStatus(String paymentStatus)
    {
        List<Rent> rents = rentRepository.findRentByPaymentStatus(paymentStatus);

        if (rents.isEmpty()) {
            LoggerUtil.error("No Rent found for payment status " + paymentStatus);
            throw new ResourceNotFoundException("No Rent found");
        }
        return ResponseEntity.ok(rents);
    }

    /** Endpoint to retrieve Rent by selecting the Rent Payment Status */
    @GetMapping("/rentByStatus")
    public ResponseEntity<List<Rent>> getRentByStatus(String rentStatus)
    {
        List<Rent> rents = rentRepository.findRentByStatus(rentStatus);

        if (rents.isEmpty()) {
            LoggerUtil.error("No Rent found for status " + rentStatus);
            throw new ResourceNotFoundException("No Rent found");
        }
        return ResponseEntity.ok(rents);
    }

    /** Endpoint to retrieve Rent by searching the customer name */
    @GetMapping("/rentByName")
    public ResponseEntity<List<Rent>> getRentByName(String name)
    {
        List<Rent> rents = rentRepository.findRentByFirstName(name);

        if (rents.isEmpty()) {
            LoggerUtil.error("No Rent found for name: " + name);
            throw new ResourceNotFoundException("No Rent found");
        }
        return ResponseEntity.ok(rents);
    }
}
