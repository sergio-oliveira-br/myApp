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

//Method to load the table of expenses.
//src/main/resources/static/js/modules/expenses/expensesTable.js

/**
 * Page: Expense
 * Item: Table
 * Method: The script will load all expenses in a table
 */
function loadExpenseTable() {
    ajaxRequest("/expense", function (data) {
        $('#expenseTable').empty();

        console.log('There are ' + data.length + ' expenses in your expenses DB.');

        data.forEach(function (expense) {
            $('#expenseTable').append('<tr>' +
                '<td>' + expense.id + '</td>' +
                '<td>' + expense.expenseDescription + '</td>' +
                '<td>' + expense.expenseAmount + '</td>' +
                '<td>' + expense.expenseDate + '</td>' +
                '<td>' + expense.expenseCategory + '</td>' +
                '<td>' + expense.expenseAdditionalNotes + '</td>' +
                '<td><button class="btn btn-primary" onclick="openExpenseEditModal(' + expense.id + ')">Edit</button></td>' +
                '</tr>'
            );
        });
    });
}
