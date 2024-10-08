package com.alucontrol.backendv1.Controllers.Expense;

import com.alucontrol.backendv1.Model.Expense;
import com.alucontrol.backendv1.Service.ExpenseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/update-expense")
public class UpdateExpenseController {

    private final ExpenseService expenseService;

    public UpdateExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Expense> updateExpense(@PathVariable("id") Long id, @RequestBody Expense expense) {
        return expenseService.saveExepenseChanges(expense, id);
    }

}
