package com.alucontrol.backendv1.controllers.customer;

import com.alucontrol.backendv1.model.Customer;
import com.alucontrol.backendv1.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
public class CreateCustomerController {

    private final CustomerService customerService;

    public CreateCustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // Este endpoint é responsavel por receber um objeto customer no corpo da requisição,
    // fazer a validacao valida os dados e, se estiverem corretos, persiste o cliente na base de dados, retornando 201
    @PostMapping("/create-customer")
    public ResponseEntity<Customer> createCustomer(@Validated @RequestBody Customer customer) {

        Customer newCustomer = customerService.saveCustomer(customer);

        return ResponseEntity.status(HttpStatus.CREATED).body(newCustomer);
    }
}
