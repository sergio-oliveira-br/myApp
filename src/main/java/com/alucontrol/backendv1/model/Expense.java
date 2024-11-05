package com.alucontrol.backendv1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

// The represents an expense entity in the application,
// This class is mapped to the "expenses" table in the database.
@Entity
@Table(name = "expenses")
public class Expense
{
    @Id //Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment by the database
    private Long id;

    @NotBlank(message = "O campo descrição da despesa não pode ser em branco")
    private String expenseDescription;

    @NotNull(message = "O valor da despsas é fundamental para esta operação")
    private double expenseAmount;

    @NotBlank(message = "A data nos ajudará a manter o registro das despesaas, por isso é um campo obrigatorio")
    private String expenseDate;

    @NotBlank(message = "A categoria da despesa é essencial para analise de gasto, por isso deve ser preenchido")
    private String expenseCategory;

    private String expenseAdditionalNotes;


    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getExpenseCategory() {
        return expenseCategory;
    }

    public void setExpenseCategory(String expenseCategory) {
        this.expenseCategory = expenseCategory;
    }

    @Override
    public String toString() {
        return "expense{" +
                "ID=" + id +
                ", expenseDescription='" + expenseDescription + '\'' +
                ", expenseAmount=" + expenseAmount +
                ", expenseDate='" + expenseDate + '\'' +
                ", expenseCategory='" + expenseCategory + '\'' +
                ", expenseAdditionalNotes='" + expenseAdditionalNotes + '\'' +
                '}';
    }
}
