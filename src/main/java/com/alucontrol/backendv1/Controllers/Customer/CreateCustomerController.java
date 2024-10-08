package com.alucontrol.backendv1.Controllers.Customer;

import com.alucontrol.backendv1.Model.Customer;
import com.alucontrol.backendv1.Service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class CreateCustomerController {

    private final CustomerService customerService;

    public CreateCustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //This endpoint is responsible to create a new Customer into a DB
    @PostMapping("/api/v1/create-customer")
    public ResponseEntity<Customer> createCustomer(@Validated @RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }
}
