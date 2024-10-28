package com.alucontrol.backendv1.ControllerTest;

import com.alucontrol.backendv1.Exception.DataAccessException;
import com.alucontrol.backendv1.Model.Customer;
import com.alucontrol.backendv1.Repository.CustomerRepository;
import com.alucontrol.backendv1.Service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


//Reference: https://site.mockito.org
@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    private Customer mockCustomer;

    // Este ira ser executado antes de cada teste
    @BeforeEach
    public void setUp() {

        // Criando um cliente simulado para os testes
        mockCustomer = new Customer();

        mockCustomer.setId(1L);
        mockCustomer.setFirstName("Sergio");
        mockCustomer.setCity("DUB");

    }

    @Nested
    class SaveCustomerTests {

        @DisplayName("Deve salvar cliente com sucesso")
        @Test
        public void saveCustomerSuccess() {

            // Configura o mock para retornar o cliente simulado ao salvar
            when(customerRepository.save(any(Customer.class))).thenReturn(mockCustomer);

            Customer savedCustomer = customerService.saveCustomer(mockCustomer);

            // Verificações de asserção
            assertNotNull(savedCustomer, "Não pode ser nulo");
            assertEquals(mockCustomer.getId(), savedCustomer.getId(), "O ID do cliente salvo deve corresponder");
            assertEquals(mockCustomer.getFirstName(), savedCustomer.getFirstName(), "O Nome do cliente salvo deve corresponder");
            assertEquals(mockCustomer.getCity(), savedCustomer.getCity(), "A cidade do cliente salvo deve corresponder");

            verify(customerRepository).save(mockCustomer);
        }


        @DisplayName("Deve lançar exceção ao falhar ao salvar")
        @Test
        public void saveCustomerFailure() {

            when(customerRepository.save(any(Customer.class))).thenThrow(new DataAccessException("Attempting to save client data was unsuccessful"));

            DataAccessException exception = assertThrows(DataAccessException.class, () -> customerService.saveCustomer(mockCustomer));

            assertEquals("Attempting to save client data was unsuccessful", exception.getMessage());
            verify(customerRepository).save(mockCustomer);
        }
    }



    @Test
    public void findAllCustomerSuccess() {

        when(customerRepository.findAll()).thenReturn(List.of(mockCustomer));

        List<Customer> allCustomers = customerService.findAllCustomers();

        assertNotNull(allCustomers);
        assertEquals(1, allCustomers.size(), "A lista deve conter 1 unico no cadastrado");
        assertEquals(mockCustomer.getId(), allCustomers.get(0).getId(), "O ID do cliente deve corresponder");
    }
}
