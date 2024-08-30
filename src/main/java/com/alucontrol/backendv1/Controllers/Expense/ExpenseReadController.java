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
import com.alucontrol.backendv1.Exception.ResourceNotFoundException;
import com.alucontrol.backendv1.Model.Expense;
import com.alucontrol.backendv1.Repository.ExpenseRepository;
import com.alucontrol.backendv1.Service.ExpenseService;
import com.alucontrol.backendv1.Util.LoggerUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/** This controller is dedicated to endpoints that read data */
@RestController
public class ExpenseReadController {

    //Repository for access to Expense data
    private final ExpenseRepository expenseRepository;
    private final ExpenseService expenseService;

    //Constructor responsible for injecting the repository
    public ExpenseReadController(ExpenseRepository expenseRepository, ExpenseService expenseService) {
        this.expenseRepository = expenseRepository;
        this.expenseService = expenseService;
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

    /** Endpoint to GET a specific product by ID */
    @GetMapping("/expense/{id}")
    public ResponseEntity<?> getExpenseById(@PathVariable Long id){
        try{
            Optional<Expense> expense = expenseRepository.findById(id);
            if (expense.isPresent()) {
                return ResponseEntity.ok(expense.get());
            }

            else {
                throw new ResourceNotFoundException("From Expenses Controller: It was not possible to locate any items");
            }
        }catch (Exception e){
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Ocorreu um erro ao buscar dados da despesa. Por favor, informe-o para o suporte técnico com fotos. " +
                            "Despesa: " + id + " | Error: " + e.getMessage() + e);

            LoggerUtil.error("Error: " + errorResponse);

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    /** Endpoint to get back expenses by selecting the "Category" */
    @GetMapping("/expensesByCategory")
    public ResponseEntity<List<Expense>> getExpensesByCategory(@RequestParam("expenseCategory") String expenseCategory)
    {
        List<Expense> expenses = expenseRepository.findByExpenseCategory(expenseCategory);
        if (expenses.isEmpty()) {
            LoggerUtil.error("No expenses found for category " + expenseCategory);
            throw new ResourceNotFoundException("No expenses found");
        }
        return ResponseEntity.ok(expenses);
    }

    /** Endpoint to retrieve expenses by selecting the "Month" and "Year" in expenseDate field */
    @GetMapping("/expensesByDate")
    public ResponseEntity<List<Expense>> getExpensesByDate(String year, String month)
    {
        List<Expense> expenses = expenseRepository.findByYearAndMonth(year, month);

        if (expenses.isEmpty()) {
            LoggerUtil.error("No expenses found for year " + year + " and month " + month);
            throw new ResourceNotFoundException("No expenses found");
        }
        return ResponseEntity.ok(expenses);
    }

}
