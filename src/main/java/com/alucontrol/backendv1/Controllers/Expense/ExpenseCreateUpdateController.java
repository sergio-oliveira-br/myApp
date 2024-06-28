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
import com.alucontrol.backendv1.Service.ExpenseService;
import com.alucontrol.backendv1.Util.LoggerUtil;
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
    private final ExpenseService expenseService;

    //Constructor responsible for injecting the repository
    private ExpenseCreateUpdateController ( ExpenseService expenseService)
    {
        this.expenseService = expenseService;
    }

    /** Endpoints */
    @PostMapping("/saveExpense")
    public ResponseEntity<Expense> saveExpense(@RequestBody Expense expense)
    {
        try {
            //Instance object
            Expense savedExpense = expenseService.createExpense(
                    expense.getExpenseDescription(),
                    expense.getExpenseAmount(),
                    expense.getExpenseDate(),
                    expense.getExpenseCategory(),
                    expense.getExpenseAdditionalNotes());

            //Create a log
            LoggerUtil.info("Save Expense Successfully, ID:" + savedExpense.getId());

            //Return a response HTTP 200 - OK - saving the expense
            return ResponseEntity.ok(savedExpense);
        }
        catch (Exception e)
        {
            //Create a log (if there is an error)
            LoggerUtil.error("Save Expense Failed: " + e.getMessage());

            //Throw the exception (if there is an error)
            return ResponseEntity.internalServerError().build();
        }
    }
}
