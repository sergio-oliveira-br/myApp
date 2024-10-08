package com.alucontrol.backendv1.Service;

import com.alucontrol.backendv1.Model.Expense;
import com.alucontrol.backendv1.Repository.ExpenseRepository;
import com.alucontrol.backendv1.Util.LoggerUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
}
