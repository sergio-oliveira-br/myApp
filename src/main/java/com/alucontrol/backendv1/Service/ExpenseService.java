package com.alucontrol.backendv1.Service;

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

    //Method para Salvar novas Despesas
    public ResponseEntity<Expense> saveExpense(Expense expense) {

        Expense savedExpense = expenseRepository.save(expense);
        LoggerUtil.info("Expense saved successfully: " + savedExpense.toString());

        return ResponseEntity.ok(savedExpense);
    }

    //Metodo de Leitura, buscando todos as despesas existentes na base de dados
    public ResponseEntity<List<Expense>> findAllExpenses() {

        List<Expense> expenses = expenseRepository.findAll();
        return ResponseEntity.ok(expenses);
    }

    //Method de Leitura, buscando uma despesa especifica
    public ResponseEntity<Expense> findExpenseById(Long id) {
        Optional<Expense> expense = expenseRepository.findById(id);

        if (expense.isPresent()) {
            return ResponseEntity.ok(expense.get());
        }

        return ResponseEntity.notFound().build();
    }


    //Metodo para atualizar uma Despesas ja existente por meio do ID
    public ResponseEntity<Expense> saveExepenseChanges(Expense expense, Long id) {

        Optional<Expense> expenseOptional = expenseRepository.findById(id);

        if (expenseOptional.isPresent()) {
            Expense savedExpense = expenseRepository.save(expense);
            LoggerUtil.info("Expense saved successfully: " + savedExpense.toString());
            return ResponseEntity.ok(savedExpense);
        }

        LoggerUtil.error("Updating Expense with id " + id + " failed.");
        return ResponseEntity.notFound().build();
    }

    //Metodo para encontrar despesas selecionando a "Category"
    public ResponseEntity<List<Expense>> findExpenseByCategory (String expenseCategory) {

        List<Expense> expensesByCategory = expenseRepository.findByExpenseCategory(expenseCategory);

        if (expensesByCategory.isEmpty()) {
            LoggerUtil.error("Category " + expenseCategory + " not found or is empty.");
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(expensesByCategory);
    }
}
