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


import com.alucontrol.backendv1.Model.Expense;
import com.alucontrol.backendv1.Repository.ExpenseRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/** This controller is dedicated to endpoints that create and update records
 * It is the responsibility of this layer to receive requests, call methods from the service layer, and return HTTP responses */
@RestController
public class ExpenseCreateUpdateController
{
    //Repository for access to expense data
    private final ExpenseRepository expenseRepository;

    //Constructor responsible for injecting the repository
    private ExpenseCreateUpdateController (ExpenseRepository expenseRepository)
    {
        this.expenseRepository = expenseRepository;
    }

    /** Endpoints */
    @PostMapping("/saveExpense")
    public ResponseEntity<Expense> saveExpense(@RequestBody Expense expense)
    {

    }

}
