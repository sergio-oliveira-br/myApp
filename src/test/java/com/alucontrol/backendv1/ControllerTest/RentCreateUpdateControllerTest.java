///**
// * National College of Ireland - NCI
// *    Higher Diploma in Computing
// *         Final Project
// *              ---
// * Author: Sergio Vinicio da Silva Oliveira
// * ID: x23170981@student.ncirl.ie
// * Project Commencing May 2024
// * Version: 1.0 - Test
// */
//package com.alucontrol.backendv1.ControllerTest;
//
////Reference: https://site.mockito.org
//
//
//import com.alucontrol.backendv1.Controllers.Rent.RentCreateUpdateController;
//import com.alucontrol.backendv1.Model.Rent;
//import com.alucontrol.backendv1.Repository.RentRepository;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import java.text.ParseException;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNull;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
///** This test focuses on the "saveRent" method by checking:
//
// -> Whether the method correctly saves a rent in the database.
// -> If the method returns a Rent object with the correct data.
// -> If the method throws an exception when an error occurs.
// -> Whether the method creates a correct log when the client is saved successfully or when an error occurs.*/
//
//@ExtendWith(MockitoExtension.class)
//public class RentCreateUpdateControllerTest
//{
//    //Inject the CustomerCreateUpdateController Controller Instance into the Test.
//    @InjectMocks
//    private RentCreateUpdateController rentCreateUpdateController;
//
//    //Create a Mock Instance of the RentRepository
//    @Mock
//    public RentRepository rentRepository;
//
//    //The success case: where the rent is saved correctly in DB
//    @Test
//    public void saveRentSuccess()
//    {
//        //Create a instance object
//        Rent rent = new Rent();
//
//        rent.setRentFirstName("RentTest");
//        rent.setRentAddress("AddressTest");
//        rent.setRentItem("ItemTest");
//        rent.setRentPrice(99);
//        rent.setRentQtyItem(99);
//        rent.setRentStarts("01/01/2024");
//        rent.setRentEnds("02/01/2024");
//        rent.setRentTotalDays(99);
//        rent.setRentTotalPrice(99);
//        rent.setRentDetails("This is a JUnitTest");
//        rent.setRentPaymentStatus("PaidTest");
//        rent.setRentStatus("NewTest");
//
//        /** Stubbing: Set the behavior of the Repository save method.
//         * When the save method is called in the rentRepository object
//         * with the rent argument, return the rent itself as a result */
//        when(rentRepository.save(any(Rent.class))).thenReturn(rent);
//
//        ResponseEntity<Rent> response;
//        response = rentCreateUpdateController.saveRent(rent);
//
//        /** The method is expected to return a response with a status code of 200 (OK) and the rent saved */
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(rent, response.getBody());
//        verify(rentRepository).save(any(Rent.class));
//    }
//
//    //The error case, where an exception is thrown when trying to save the product to the database.
//    @Test
//    public void saveRentError() throws Exception
//    {
//        //Create a instance object
//        Rent rent = new Rent();
//
//        rent.setRentFirstName("RentTest");
//        rent.setRentAddress("AddressTest");
//        rent.setRentItem("ItemTest");
//        rent.setRentPrice(99);
//        rent.setRentQtyItem(99);
//        rent.setRentStarts("01/01/2024");
//        rent.setRentEnds("02/01/2024");
//        rent.setRentTotalDays(99);
//        rent.setRentTotalPrice(99);
//        rent.setRentDetails("This is a JUnitTest");
//        rent.setRentPaymentStatus("PaidTest");
//        rent.setRentStatus("NewTest");
//
//        //Mockito will throw an Exception instead of actually saving the rent in to the database
//        when(rentRepository.save(any(Rent.class))).thenThrow(new ParseException("An error occurred while trying to save.", 0));
//
//        ResponseEntity<Rent> response;
//        response = rentCreateUpdateController.saveRent(rent);
//
//        //Checks whether the server response is an internal error (500) and whether the response body is empty
//        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
//
//        //Checks if the response body is empty, as there is nothing to be returned in case of error
//        assertNull(response.getBody());
//    }
//}
