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
    public ResponseEntity<Customer> saveCustomer( @RequestBody Customer customer) {
        try {
            //Save the customer in the database
            Customer savedCustomer = customerRepository.save(customer);

            //Create a log
            LoggerUtil.info("Customer saved successfully, ID: "  + customer.getId() +", " + customer.getFirstName());

            return ResponseEntity.ok(savedCustomer); //return the saved customer data
        }
        catch (Exception e) {
            LoggerUtil.error("An error occurred while saving customer data: " + e.getMessage(), e); //create log
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); //Return an internal error
        }
    }
}
