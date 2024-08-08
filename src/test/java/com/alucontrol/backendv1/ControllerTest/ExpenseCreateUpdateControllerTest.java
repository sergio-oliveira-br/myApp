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
//import com.alucontrol.backendv1.Controllers.Expense.ExpenseCreateUpdateController;
//import com.alucontrol.backendv1.Model.Expense;
//import com.alucontrol.backendv1.Repository.ExpenseRepository;
//import com.alucontrol.backendv1.Service.ExpenseService;
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
//import static org.junit.jupiter.api.Assertions.assertNull;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.util.AssertionErrors.assertEquals;
//
///** This test focuses on the "saveRent" method by checking:
//
// -> Whether the method correctly saves a rent in the database.
// -> If the method returns a Rent object with the correct data.
// -> If the method throws an exception when an error occurs.
// -> Whether the method creates a correct log when the client is saved successfully or when an error occurs.*/
//@ExtendWith(MockitoExtension.class)
//public class ExpenseCreateUpdateControllerTest
//{
//    //Inject the ExpenseCreateUpdateController Controller Instance into the Test
//    @InjectMocks
//    private ExpenseCreateUpdateController expenseCreateUpdateController;
//
//    //Create a Mock Instance of the ExpenseRepository
//    @Mock
//    private ExpenseRepository expenseRepository;
//
//    /** The success case: where the product is saved correctly in DB*/
//    @Test
//    public void saveExpenseTest()
//    {
//        //Instance an object
//        Expense expense = new Expense();
//
//        //Set values
//        expense.setExpenseDescription("descriptionTest");
//        expense.setExpenseCategory("categoryTest");
//        expense.setExpenseDate("29/06/2024");
//        expense.setExpenseAmount(123.45);
//        expense.setExpenseAdditionalNotes("This is a JUnit Test");
//
//        //Stubbing: Set the behavior of the Repository save method.
//        try {
//            when(expenseRepository.save(any(Expense.class))).thenReturn(expense);
//        }
//
//        catch (Exception e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//        ResponseEntity<Expense> response = expenseCreateUpdateController.saveExpense(expense);
//
//        //The method is expected to return a response with a status code of 200 (OK) and the expense saved
//        assertEquals("Successful: " , HttpStatus.OK, response.getStatusCode());
//        assertEquals("Successful: ", expense, response.getBody());
//        try{
//            verify(expenseRepository).save(any(Expense.class));
//
//        }catch (Exception e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//    }
//
//    /** The error case, where an exception is thrown when trying to save the expense to the DB */
//    @Test
//    public void saveExpenseError() throws Exception {
//
//        Expense expense = new Expense();
//
//        //Set values
//        expense.setExpenseDescription("descriptionTest");
//        expense.setExpenseCategory("categoryTest");
//        expense.setExpenseDate("29/06/2024");
//        expense.setExpenseAmount(123.45);
//        expense.setExpenseAdditionalNotes("This is a JUnit Test");
//
//        //Mockito will throw an Exception instead of actually saving the expense in to the DB
//            when(expenseRepository.save(any(Expense.class)))
//                    .thenThrow(new ParseException("Error: An exception is thrown when trying to save the expense to the DB", 0));
//
//        ResponseEntity<Expense> response = expenseCreateUpdateController.saveExpense(expense);
//
//        //Checks whether the server response is an internal error (500) and whether the response body is empty
//        assertEquals("Error: " , HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
//
//        //Checks if the response body is empty, as there is nothing to be returned in case of error
//        assertNull(response.getBody());
//    }
//}
