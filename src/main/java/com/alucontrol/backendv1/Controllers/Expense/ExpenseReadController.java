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

import com.alucontrol.backendv1.Exception.ResourceNotFoundException;
import com.alucontrol.backendv1.Model.Expense;
import com.alucontrol.backendv1.Repository.ExpenseRepository;
import com.alucontrol.backendv1.Util.LoggerUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/** This controller is dedicated to endpoints that read data */
@RestController
public class ExpenseReadController {

    //Repository for access to Expense data
    private final ExpenseRepository expenseRepository;

    //Constructor responsible for injecting the repository
    public ExpenseReadController(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    /** Endpoint to get back all expenses */
    @GetMapping("/expense")
    public ResponseEntity<List<Expense>> getAllExpenses()
    {
        //findAll() is method inherited from CrudRepository
        List<Expense> expenses = expenseRepository.findAll();

        if (expenses.isEmpty()) {
            LoggerUtil.error("No expenses found");
            throw new ResourceNotFoundException("No expenses found");
        }

        //Returns a 200 OK HTTP response with the list of expenses in the body.
        return ResponseEntity.ok(expenses);
    }
}
