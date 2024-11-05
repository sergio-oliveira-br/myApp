package com.alucontrol.backendv1.controllers.expense;

import com.alucontrol.backendv1.model.Expense;
import com.alucontrol.backendv1.service.ExpenseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/expense")
public class UpdateExpenseController {

    private final ExpenseService expenseService;

    public UpdateExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PutMapping("/update-expense/{id}")
    public ResponseEntity<Expense> updateExpense(@PathVariable("id") Long id, @RequestBody Expense expense) {

        Expense updatedExpense = expenseService.saveExepenseChanges(expense, id);

        return ResponseEntity.ok(updatedExpense);
    }
}
