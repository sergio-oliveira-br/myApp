package com.alucontrol.backendv1.Service;

import com.alucontrol.backendv1.Exception.DataAccessException;
import com.alucontrol.backendv1.Exception.InternalServerException;
import com.alucontrol.backendv1.Model.Customer;
import com.alucontrol.backendv1.Repository.CustomerRepository;
import com.alucontrol.backendv1.Util.LoggerUtil;
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

            LoggerUtil.info("Customer saved successfully: "  + savedCustomer);
            return savedCustomer;

        }catch (DataAccessException e){
            LoggerUtil.error("Failed to save customer: " + e.getMessage(), e);
            throw new InternalServerException("Failed to save customer data", e);
        }
    }

    //Metodo de Leitura, este metodo irá buscar todos os clientes no banco de dados
    public List<Customer> findAllCustomers() {

        return customerRepository.findAll();
    }
}
