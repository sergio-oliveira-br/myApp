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

//This aim a useful class that would be to centralize and encapsulate common functionalities
//to several parts of the code, promoting reuse, modularity and maintainability.
//src/main/resources/static/js/modules/expenses/expensesReport/expensesUtil.js

/** This function will take arguments for filtering criteria and handle the AJAX request and table population. */
function loadFilteredExpenses(url, successCallback) {
    ajaxRequest(url, function(data) {
        $('#expensesListReport').empty();

        data.forEach(function(expense) {
            $('#expensesListReport').append('<tr>' +
                '<td>' + expense.id + '</td>' +
                '<td>' + expense.expenseDescription + '</td>' +
                '<td>' + expense.expenseAmount + '</td>' +
                '<td>' + expense.expenseDate + '</td>' +
                '<td>' + expense.expenseCategory + '</td>' +
                '<td>' + expense.expenseAdditionalNotes + '</td>' +
                '</tr>');
        });

        if (successCallback) {
            successCallback(data);
        }
    });
}