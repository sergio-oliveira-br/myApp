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
    private Long id;

    @Column(nullable = false) //cannot be null
    private String expenseDescription;

    @Column(nullable = false) //cannot be null
    private double expenseAmount;

    @Column(nullable = false) //cannot be null
    private String expenseDate;

    @Column(nullable = false) //cannot be null
    private String expenseCategory;

//    @Column(nullable = false) //cannot be null
//    private String ExpenseType;

    @Column(nullable = true)
    private String expenseAdditionalNotes;


    /** Getters and Setters */
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getExpenseDescription() {
        return expenseDescription;
    }

    public void setExpenseDescription(String expenseDescription) {
        this.expenseDescription = expenseDescription;
    }

    public double getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(double expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public String getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(String expenseDate) {
        this.expenseDate = expenseDate;
    }

    public String getExpenseCategory() {
        return expenseCategory;
    }

    public void setExpenseCategory(String expenseCategory) {
        this.expenseCategory = expenseCategory;
    }

//    public String getExpenseType() {
//        return ExpenseType;
//    }
//
//    public void setExpenseType(String expenseType) {
//        ExpenseType = expenseType;
//    }

    public String getExpenseAdditionalNotes() {
        return expenseAdditionalNotes;
    }

    public void setExpenseAdditionalNotes(String expenseAdditionalNotes) {
        this.expenseAdditionalNotes = expenseAdditionalNotes;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "ID=" + id +
                ", expenseDescription='" + expenseDescription + '\'' +
                ", expenseAmount=" + expenseAmount +
                ", expenseDate='" + expenseDate + '\'' +
                ", expenseCategory='" + expenseCategory + '\'' +
                ", expenseAdditionalNotes='" + expenseAdditionalNotes + '\'' +
                '}';
    }
}
