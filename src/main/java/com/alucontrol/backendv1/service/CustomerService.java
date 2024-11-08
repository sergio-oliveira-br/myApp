package com.alucontrol.backendv1.service;

import com.alucontrol.backendv1.exception.DataAccessException;
import com.alucontrol.backendv1.exception.InternalServerException;
import com.alucontrol.backendv1.model.Customer;
import com.alucontrol.backendv1.repository.CustomerRepository;
import com.alucontrol.backendv1.util.LoggerUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService (CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    //Metodo de Salvamento, utilizado na criacao de um novo cliente
    public Customer saveCustomer (Customer customer) {

        try{
            Customer savedCustomer = customerRepository.save(customer);

            LoggerUtil.info("customer saved successfully: "  + savedCustomer);
            return savedCustomer;

        }catch (DataAccessException e){
            LoggerUtil.error("Error while saving customer: " + customer, e);
            throw new InternalServerException("Failed to save customer data. " + e.getMessage());
        }
    }

    //Metodo de Leitura, este metodo irá buscar todos os clientes no banco de dados
    public List<Customer> findAllCustomers() {

        return customerRepository.findAll();
    }
}
