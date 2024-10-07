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


import com.alucontrol.backendv1.Exception.ProblemDetails;
import com.alucontrol.backendv1.Model.Expense;
import com.alucontrol.backendv1.Repository.ExpenseRepository;
import com.alucontrol.backendv1.Util.LoggerUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    public ResponseEntity<Expense> saveExpense(@RequestBody Expense expense) {

        //Log
        LoggerUtil.info("Starting to save Expense with data: " + expense.toString());

        //Save the customer in the database
        Expense savedExpense = expenseRepository.save(expense);

        //Log and Return a response HTTP 200 - OK - saving the expense
        LoggerUtil.info("Expense Saved Successfully: " + savedExpense.toString());
        return ResponseEntity.ok(savedExpense);
    }

    /** Endpoint to update a specific expense by ID */
    @PutMapping("/expense/{id}")
    public ResponseEntity<Expense> updateExpense(@RequestBody Expense expenseUpdated, @PathVariable Long id) {

        Optional<Expense> expenseOptional = expenseRepository.findById(id);

        if (expenseOptional.isPresent()) {
            LoggerUtil.info("Starting to update Expense with data: " + expenseOptional.toString());

            Expense savedExpense = expenseRepository.save(expenseUpdated);

            LoggerUtil.info("Expense Updated Successfully: " + savedExpense.toString());
            return ResponseEntity.ok(savedExpense);
        }
        else {
            LoggerUtil.info("Updating Expense with id " + id + " failed.");
            return ResponseEntity.notFound().build();
        }
    }
}
