package com.alucontrol.backendv1.Service;

import com.alucontrol.backendv1.Model.Customer;
import com.alucontrol.backendv1.Repository.CustomerRepository;
import com.alucontrol.backendv1.Util.LoggerUtil;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService (CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    //Metodo de Salvamento
    public ResponseEntity<Customer> saveCustomer (Customer customer) {
        try {
            Customer savedCustomer = customerRepository.save(customer);
            LoggerUtil.info("Customer saved successfully: "  + savedCustomer.toString());
            return ResponseEntity.ok(savedCustomer);

        }catch (DataAccessException e){
            LoggerUtil.error("Error while saving customer: "  + customer.toString());
            throw e;
        }
    }

    //Metodo de Leitura
    public ResponseEntity<List<Customer>> getAllCustomers () {
        try{
            List<Customer> customers = customerRepository.findAll();
            return ResponseEntity.ok(customers);

        }catch (DataAccessException e){
            LoggerUtil.error("Error while getting all customer: "  + e.getMessage(), e);
            throw e;
        }
    }
}
