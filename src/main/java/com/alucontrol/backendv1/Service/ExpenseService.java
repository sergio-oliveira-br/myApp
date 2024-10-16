package com.alucontrol.backendv1.Service;

import com.alucontrol.backendv1.Exception.ResourceNotFoundException;
import com.alucontrol.backendv1.Model.Expense;
import com.alucontrol.backendv1.Repository.ExpenseRepository;
import com.alucontrol.backendv1.Util.LoggerUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    //Metodo para Salvar novas Despesas
    public ResponseEntity<Expense> saveExpense(Expense expense) {

        Expense savedExpense = expenseRepository.save(expense);
        LoggerUtil.info("Expense saved successfully: " + savedExpense.toString());

        return ResponseEntity.ok(savedExpense);
    }

    //Metodo de Atualização de Despesas ja existente por meio do ID
    public ResponseEntity<Expense> saveExepenseChanges(Expense expense, Long id) {

        Optional<Expense> expenseOptional = expenseRepository.findById(id);

        if (expenseOptional.isPresent()) {
            Expense savedExpense = expenseRepository.save(expense);
            LoggerUtil.info("Expense saved successfully: " + savedExpense.toString());
            return ResponseEntity.ok(savedExpense);
        }

       throw new ResourceNotFoundException("Expense ID " + id + " not found");
    }

    //Metodo de Leitura buscando todos as despesas existentes na base de dados
    public ResponseEntity<List<Expense>> findAllExpenses() {

        List<Expense> expenses = expenseRepository.findAll();
        return ResponseEntity.ok(expenses);
    }

    //Method de Leitura buscando uma despesa especifica
    public ResponseEntity<Expense> findExpenseById(Long id) {
        Optional<Expense> expense = expenseRepository.findById(id);

        if (expense.isPresent()) {
            return ResponseEntity.ok(expense.get());
        }

        throw new ResourceNotFoundException("Expense ID " + id + " not found");
    }

    //Metodo de Leitura para encontrar despesas selecionando a "Category"
    public ResponseEntity<List<Expense>> findExpenseByCategory (String expenseCategory) {

        List<Expense> expensesByCategory = expenseRepository.findByExpenseCategory(expenseCategory);

        if (expensesByCategory.isEmpty()) {
            throw new ResourceNotFoundException("Expense category " + expenseCategory + " not found");
        }

        return ResponseEntity.ok(expensesByCategory);
    }

    //Metodo Leitura para encontrar despesas informando o mes e o ano.
    public ResponseEntity<List<Expense>> findExpenseByDate (String year, String month) {

        List<Expense> expensesByDate = expenseRepository.findByYearAndMonth(year, month);

        if (expensesByDate.isEmpty()) {
            throw new ResourceNotFoundException("Expense " + year + "-" + month + " not found");
        }

        return ResponseEntity.ok(expensesByDate);
    }
}
