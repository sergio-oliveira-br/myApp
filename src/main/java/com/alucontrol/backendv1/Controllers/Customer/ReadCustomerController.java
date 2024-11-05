package com.alucontrol.backendv1.Controllers.Customer;

import com.alucontrol.backendv1.Model.Customer;
import com.alucontrol.backendv1.Service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class ReadCustomerController {
    public final CustomerService customerService;

    public ReadCustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //endpoint para obter todos os clientes presente na base de dados
    @GetMapping
    public ResponseEntity<List<Customer>> getCustomers() {
        List<Customer> customers = customerService.findAllCustomers();
        return ResponseEntity.ok(customers);
    }
}
