package com.alucontrol.backendv1.Controllers.Expense;

import com.alucontrol.backendv1.Exception.ResourceNotFoundException;
import com.alucontrol.backendv1.Model.Expense;
import com.alucontrol.backendv1.Repository.ExpenseRepository;
import com.alucontrol.backendv1.Service.ExpenseService;
import com.alucontrol.backendv1.Util.LoggerUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/expense")
public class ReadExpenseController {

    private final ExpenseRepository expenseRepository;
    private final ExpenseService expenseService;

    public ReadExpenseController(ExpenseRepository expenseRepository, ExpenseService expenseService) {
        this.expenseRepository = expenseRepository;
        this.expenseService = expenseService;
    }

    //Endpoit para buscar todos as despesas presentes no banco de dados.
    @GetMapping()
    public ResponseEntity<List<Expense>> getExpense() {
        return expenseService.findAllExpenses();
    }

    //Method para buscar uma despesa específica atraves do id.
    @GetMapping("/{id}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable Long id){
        return expenseService.findExpenseById(id);
    }

    //Metodo para buscar uma lista de despesas atraves da categoria.
    @GetMapping("/category")
    public ResponseEntity<List<Expense>> getExpensesByCategory(@RequestParam("expenseCategory") String expenseCategory) {
        return expenseService.findExpenseByCategory(expenseCategory);
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
