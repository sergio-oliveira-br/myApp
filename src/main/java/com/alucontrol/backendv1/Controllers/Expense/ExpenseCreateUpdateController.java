/**
 * National College of Ireland - NCI
 *    Higher Diploma in Computing
 *         Final Project
 *              ---
 * Author: Sergio Vinicio da Silva Oliveira
 * ID: x23170981@student.ncirl.ie
 * Project Commencing May 2024
 * Version: 1.0
 */
package com.alucontrol.backendv1.Controllers.Expense;


import com.alucontrol.backendv1.Exception.ErrorResponse;
import com.alucontrol.backendv1.Model.Customer;
import com.alucontrol.backendv1.Model.Expense;
import com.alucontrol.backendv1.Repository.ExpenseRepository;
import com.alucontrol.backendv1.Service.ExpenseService;
import com.alucontrol.backendv1.Util.LoggerUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/** This controller is dedicated to endpoints that create and update records
 * It is the responsibility of this layer to receive requests, call methods from the service layer, and return HTTP responses */
@RestController
public class ExpenseCreateUpdateController
{
    private final ExpenseRepository expenseRepository;

    //Constructor responsible for injecting the repository
    private ExpenseCreateUpdateController (ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    /** Endpoint to sent Expenses to DB */
    @PostMapping("/saveExpense")
    public ResponseEntity<?> saveExpense(@RequestBody Expense expense) {
    //the "?" makes the method be of the generic type or a type that can return different types of response
        try {
            //Log
            LoggerUtil.info("Starting to save Expense with data: " + expense.toString());

            //Save the customer in the database
            Expense savedExpense = expenseRepository.save(expense);

            //Log
            LoggerUtil.info("Expense Saved Successfully: " + savedExpense.toString());

            //Return a response HTTP 200 - OK - saving the expense
            return ResponseEntity.ok(savedExpense);
        }
        catch (Exception e) {
            LoggerUtil.error("An error occurred while saving Expense data." +
                    "Expense: " + expense.toString() + " | " +
                    "Error: " + e.getMessage(), e);

            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "An error has been discovered during this operation. " +
                            "Please report it to technical support with pictures." + " | " +
                            "Error: " + e.getMessage());

            //Throw the exception (if there is an error)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
}
