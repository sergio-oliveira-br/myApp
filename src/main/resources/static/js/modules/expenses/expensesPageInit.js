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

//This file centralizes all boot calls in one place, making it easy to understand and maintain.
//src/main/resources/static/js/modules/expenses/expensesPageInit.js

$(document).ready(function () {
    //Load the table
    loadExpenseTable();

    //(Modal) Send the data by clicking on submit button
    $('#editModal').on('submit', function(e) {
        //The preventDefault() method cancels the event if it is cancelable,
        //meaning that the default action that belongs to the event will not occur.
        e.preventDefault();
    });
})