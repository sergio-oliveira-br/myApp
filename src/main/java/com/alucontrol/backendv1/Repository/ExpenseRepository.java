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
package com.alucontrol.backendv1.Repository;

import com.alucontrol.backendv1.Model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/** This is responsible for managing the persistence of Expense data
 *  in the database, providing a simplified interface for CRUD operations
 */
@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long>
{
    /** Display: on Report Page via ExpenseReadController
     *  by Category -> Acquisition of Cost, Maintenance Expense, Utilities Expenses and Others
     *  Method: List all info by selecting the category
     * */
    List<Expense> findByExpenseCategory(String category);



    /** Display: on Report Page via ExpenseReadController
     *  by Date -> Month and Year
     *  Method: List all info by selecting the date
     * */
    List<Expense> findByExpenseDate(LocalDate startMonth, LocalDate endMonth);
}
