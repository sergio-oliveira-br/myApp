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
import org.springframework.stereotype.Service;

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

    /** This method will allow the user create a new expense */
    public Expense createExpense() throws Exception
    {

    }

}
