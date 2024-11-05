package com.alucontrol.backendv1.Controllers.Expense;


import com.alucontrol.backendv1.Model.Expense;
import com.alucontrol.backendv1.Service.ExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/expense")
public class CreateExpenseController {

    private final ExpenseService expenseService;

    public CreateExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping("/create-expense")
    public ResponseEntity<Expense> createExpense(@RequestBody Expense expense) {

        Expense newExpense = expenseService.saveExpense(expense);

        return ResponseEntity.status(HttpStatus.CREATED).body(newExpense);
    }
}
