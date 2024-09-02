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

//Method for filtering expenses by category.
//src/main/resources/static/js/modules/expenses/expensesReport/expensesCategoryFilter.js

/**
 * Page: Expense Report
 * Item: Table
 * Method: Load expenses filtered by category
 */
function getExpensesByCategory(category) {
    console.log("Category selected: " + category);
    let url = "/expensesByCategory?expenseCategory=" + encodeURIComponent(category);
    ajaxRequest(url, function (data) {
        $('#expensesListReport').empty();
        data.forEach(function (expense) {
            $('#expensesListReport').append('<tr>' +
                '<td>' + expense.id + '</td>' +
                '<td>' + expense.expenseDescription + '</td>' +
                '<td>' + expense.expenseAmount + '</td>' +
                '<td>' + expense.expenseDate + '</td>' +
                '<td>' + expense.expenseCategory + '</td>' +
                '<td>' + expense.expenseAdditionalNotes + '</td>' +
                '</tr>');
        });
    });
}