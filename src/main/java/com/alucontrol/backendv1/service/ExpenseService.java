package com.alucontrol.backendv1.service;

import com.alucontrol.backendv1.exception.DataAccessException;
import com.alucontrol.backendv1.exception.InternalServerException;
import com.alucontrol.backendv1.exception.ResourceNotFoundException;
import com.alucontrol.backendv1.model.Expense;
import com.alucontrol.backendv1.repository.ExpenseRepository;
import com.alucontrol.backendv1.util.LoggerUtil;
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
    public Expense saveExpense(Expense expense) {

        try{
            Expense savedExpense = expenseRepository.save(expense);

            LoggerUtil.info("expense saved successfully: " + savedExpense);
            return savedExpense;

        }catch (DataAccessException e){
            LoggerUtil.error("Failed to save expense: " + e.getMessage(), e);
            throw new InternalServerException("Failed to save expense data", e);
        }
    }

    //Metodo de Atualização de Despesas ja existente por meio do "ID"
    public Expense saveExepenseChanges(Expense expense, Long id) {

        Optional<Expense> expenseOptional = expenseRepository.findById(id);

        if (expenseOptional.isPresent()) {
            Expense savedExpense = expenseRepository.save(expense);

            LoggerUtil.info("expense saved successfully: " + savedExpense);
            return savedExpense;
        }

       throw new ResourceNotFoundException("expense ID:" + id + " not found");
    }

    //Metodo de Leitura buscando todos as despesas existentes na base de dados
    public List<Expense> findAllExpenses() {

        return expenseRepository.findAll();
    }

    //Method de Leitura buscando uma despesa especifica
    public Expense findExpenseById(Long id) {

        Optional<Expense> expense = expenseRepository.findById(id);

        if (expense.isPresent()) {
            return expense.get();
        }

        throw new ResourceNotFoundException("expense ID:" + id + " not found");
    }

    //Metodo de Leitura para encontrar despesas selecionando a "Category"
    public List<Expense> findExpenseByCategory (String expenseCategory) {

        List<Expense> expensesByCategory = expenseRepository.findByExpenseCategory(expenseCategory);

        if (expensesByCategory.isEmpty()) {
            throw new ResourceNotFoundException("expense category " + expenseCategory + " not found");
        }

        return expensesByCategory;
    }

    //Metodo Leitura para encontrar despesas informando o mes e o ano.
    public List<Expense> findExpenseByDate (String year, String month) {

        List<Expense> expensesByDate = expenseRepository.findByYearAndMonth(year, month);

        if (expensesByDate.isEmpty()) {
            throw new ResourceNotFoundException("expense " + year + "-" + month + " not found");
        }

        return expensesByDate;
    }
}
