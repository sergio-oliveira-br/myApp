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

package com.alucontrol.backendv1.Controllers.Customer;

import com.alucontrol.backendv1.Exception.ProblemDetails;
import com.alucontrol.backendv1.Repository.CustomerRepository;
import com.alucontrol.backendv1.Model.Customer;
import com.alucontrol.backendv1.Util.LoggerUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**This controller is dedicated to endpoints that create and update records
 * It's the responsibility of this layer to receive requests, call methods from the service layer, and return HTTP responses */
@RestController
public class CustomerCreateUpdateController
{
    //Repository for access to Customers data
    private final CustomerRepository customerRepository;

    //Constructor responsible for injecting the repository
    public CustomerCreateUpdateController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    /** Endpoint to send customers */
    @PostMapping("/saveCustomer")
    //the "?" makes the method be of the generic type or a type that can return different types of response
    public ResponseEntity<?> saveCustomer( @RequestBody Customer customer) {
        try {
            //Log
            LoggerUtil.info("Starting to save customer with data: " + customer.toString());

            //Save the customer in the database
            Customer savedCustomer = customerRepository.save(customer);

            //Create a log
            LoggerUtil.info("Customer saved successfully: "  + savedCustomer.toString());

            return ResponseEntity.ok(savedCustomer); //return the saved customer data
        }
        catch (Exception e) {
            //Log
            LoggerUtil.error("An error occurred while saving customer data." +
                            "Customer: " + customer.toString() + " | " +
                            "Error: " + e.getMessage(), e);

            ProblemDetails problemDetails = new ProblemDetails(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "An error has been discovered during this operation. " +
                            "Please report it to technical support with pictures.");

            //Return of an HTTP response with the error body and status
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(problemDetails);
        }
    }
}
