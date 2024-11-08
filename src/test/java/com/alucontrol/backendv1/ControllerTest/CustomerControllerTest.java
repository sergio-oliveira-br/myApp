//package com.alucontrol.backendv1.ControllerTest;
//
//import com.alucontrol.backendv1.controllers.customer.CreateCustomerController;
//import com.alucontrol.backendv1.model.customer;
//import com.alucontrol.backendv1.service.CustomerService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultMatcher;
//
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//
//@ExtendWith(SpringExtension.class)
//@WebMvcTest(CreateCustomerController.class)
//public class CustomerControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private CustomerService customerService;
//
//    @Test
//    public void createCustomerSucess() throws exception {
//
//        customer customer = new customer();
//
//        customer.setId(1L);
//        customer.setFirstName("Sergio");
//        customer.setCity("DUB");
//
//        when(customerService.saveCustomer(any(customer.class))).thenReturn(customer);
//
//        mockMvc.perform(post("/api/v1/customer/create-customer")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("{\"id\":1,\"firstName\":\"Sergio\",\"city\":\"DUB\"}"))
//                .andExpect(status().isCreated())
//                .andExpect(jsonPath("$.id").value(1))
//                .andExpect(jsonPath("$.firstName").value("Sergio"))
//                .andExpect(jsonPath("$.city").value("DUB"));
//    }
//}
