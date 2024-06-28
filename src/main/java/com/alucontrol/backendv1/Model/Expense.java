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
package com.alucontrol.backendv1.Model;

import jakarta.persistence.*;

/** The Expense class represents an expense entity in the application
 *  This class is mapped to the "expenses" table in the database.*/
@Entity
@Table(name = "expenses")
public class Expense
{
    @Id //Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment by the database
    private long id;

    @Column(nullable = false) //cannot be null
    private String ExpenseDescription;

    @Column(nullable = false) //cannot be null
    private Double ExpenseAmount;

    @Column(nullable = false) //cannot be null
    private String ExpenseDate;

    @Column(nullable = false) //cannot be null
    private String ExpenseCategory;

    @Column(nullable = false) //cannot be null
    private String ExpenseType;

    @Column(nullable = false)
    private String ExpenseAdditionalNotes;


    /** Getters and Setters */
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getExpenseDescription() {
        return ExpenseDescription;
    }

    public void setExpenseDescription(String expenseDescription) {
        ExpenseDescription = expenseDescription;
    }

    public Double getExpenseAmount() {
        return ExpenseAmount;
    }

    public void setExpenseAmount(Double expenseAmount) {
        ExpenseAmount = expenseAmount;
    }

    public String getExpenseDate() {
        return ExpenseDate;
    }

    public void setExpenseDate(String expenseDate) {
        ExpenseDate = expenseDate;
    }

    public String getExpenseCategory() {
        return ExpenseCategory;
    }

    public void setExpenseCategory(String expenseCategory) {
        ExpenseCategory = expenseCategory;
    }

    public String getExpenseType() {
        return ExpenseType;
    }

    public void setExpenseType(String expenseType) {
        ExpenseType = expenseType;
    }

    public String getExpenseAdditionalNotes() {
        return ExpenseAdditionalNotes;
    }

    public void setExpenseAdditionalNotes(String expenseAdditionalNotes) {
        ExpenseAdditionalNotes = expenseAdditionalNotes;
    }
}
