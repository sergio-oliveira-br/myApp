/**
 * National College of Ireland - NCI
 *    Higher Diploma in Computing
 *         Final Project
 *              ---
 * Author: Sergio Vinicio da Silva Oliveira
 * ID: x23170981@student.ncirl.ie
 * Project Commencing May 2024
 * Version: 1.0
 */
package com.alucontrol.backendv1.Service;

import com.alucontrol.backendv1.Model.Expense;
import com.alucontrol.backendv1.Repository.ExpenseRepository;
import com.alucontrol.backendv1.Util.DateUtil;
import com.alucontrol.backendv1.Util.LoggerUtil;
import org.springframework.stereotype.Service;

import java.util.Date;

/** This Service Class has methods that contain business logic.*/
@Service
public class ExpenseService
{
    //Repository for access to Expense data
    private final ExpenseRepository expenseRepository;

    //Constructor responsible for injecting the repository
    public ExpenseService(ExpenseRepository expenseRepository)
    {
        this.expenseRepository = expenseRepository;
    }

    /** Used: Expense Page through the Controller
     *  Method: This method will allow the user create a new expense */
    public Expense createExpense(String expenseDescription, Double expenseAmount,
                                 String expenseDate,String expenseCategory,
                                 String expenseAdditionalNotes) throws Exception
    {
        try {
            //Creates a new instance of Expense
            Expense expense = new Expense();

            //Set the values
            expense.setExpenseDescription(expenseDescription);
            expense.setExpenseAmount(expenseAmount);
            expense.setExpenseDate(expenseDate);
            expense.setExpenseCategory(expenseCategory);
            expense.setExpenseAdditionalNotes(expenseAdditionalNotes);

            //Create a log
            LoggerUtil.info("Expense created" + expense.getId());

            //Saves the new expense in the repository and returns it.
            return expenseRepository.save(expense);
        }
        catch (Exception e)
        {
            //Create a log (if there is an error)
            LoggerUtil.info("Error creating expense");

            //Throw the exception (if there is an error)
            throw new Exception(e.getMessage());
        }
    }
}
