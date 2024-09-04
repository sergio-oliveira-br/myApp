/**
 * National College of Ireland - NCI
 *    Higher Diploma in Computing
 *         Final Project
 *              ---
 * Author: Sergio Vinicio da Silva Oliveira
 * ID: x23170981@student.ncirl.ie, oliveira-sergio@outlook.com
 * Project Commencing May 2024 | Version: 1.0
 * Refactoring & New Features - Aug 2024 | Version: 2.0
 */

//Methods related to sending the expense form.
//src/main/resources/static/js/modules/expenses/expensesForm.js

/**
 * Item: Form
 * Method: Send the expense data by using AJAX
 */
formSubmission('#expenseForm', '/saveExpense', expenseFormData, expenseSaveSuccess);

/**
 * Get the form data from the form
 */
function expenseFormData() {
    return {
        expenseDescription: $('#expenseDescription').val(),
        expenseAmount: $('#expenseAmount').val(),
        expenseDate: $('#expenseDate').val(),
        expenseCategory: $('#expenseCategory').val(),
        expenseAdditionalNotes: $('#expenseAdditionalNotes').val()
    };
}

/**
 * Item: Form, Save
 * Method: Callback function for success
 */
function expenseSaveSuccess(response) {
    alert('Despesa adicionada com sucesso!');
    loadExpenseTable(); // update the expense table

    // Clear the form by resetting it
    document.getElementById('expenseForm').reset();
}
