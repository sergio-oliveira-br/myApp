package com.alucontrol.backendv1.Controllers.Expense;


import com.alucontrol.backendv1.Model.Expense;
import com.alucontrol.backendv1.Service.ExpenseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/create-expense")
public class CreateExpenseController {

    private final ExpenseService expenseService;

    public CreateExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping()
    public ResponseEntity<Expense> createExpense(@RequestBody Expense expense) {
        return expenseService.saveExpense(expense);
    }





//    /** Endpoint to update a specific expense by ID */
//    @PutMapping("/expense/{id}")
//    public ResponseEntity<Expense> updateExpense(@RequestBody Expense expenseUpdated, @PathVariable Long id) {
//
//        Optional<Expense> expenseOptional = expenseRepository.findById(id);
//
//        if (expenseOptional.isPresent()) {
//            LoggerUtil.info("Starting to update Expense with data: " + expenseOptional.toString());
//
//            Expense savedExpense = expenseRepository.save(expenseUpdated);
//
//            LoggerUtil.info("Expense Updated Successfully: " + savedExpense.toString());
//            return ResponseEntity.ok(savedExpense);
//        }
//        else {
//            LoggerUtil.info("Updating Expense with id " + id + " failed.");
//            return ResponseEntity.notFound().build();
//        }
//    }
}
