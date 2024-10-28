package com.alucontrol.backendv1.Controllers.Expense;

import com.alucontrol.backendv1.Model.Expense;
import com.alucontrol.backendv1.Service.ExpenseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/expense")
public class ReadExpenseController {

    private final ExpenseService expenseService;

    public ReadExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    //Endpoit para buscar todos as despesas presentes no banco de dados.
    @GetMapping()
    public ResponseEntity<List<Expense>> getAllExpenses() {

        List<Expense> allExpenses = expenseService.findAllExpenses();

        return ResponseEntity.ok(allExpenses);
    }

    //Method para buscar uma despesa específica atraves do id.
    @GetMapping("/{id}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable Long id){

        Expense expenseFound = expenseService.findExpenseById(id);
        
        return ResponseEntity.ok(expenseFound);
    }

    //Metodo para buscar uma lista de despesas atraves da categoria.
    @GetMapping("/category")
    public ResponseEntity<List<Expense>> getExpensesByCategory(@RequestParam("expenseCategory") String expenseCategory) {
        return expenseService.findExpenseByCategory(expenseCategory);
    }

    //Metodo para buscar/filtrar a lista de despesas atraves do "Month" e "Year"
    @GetMapping("/year-month")
    public ResponseEntity<List<Expense>> getExpenseByDate(String year, String month) {
      return expenseService.findExpenseByDate(year, month);
    }

}
