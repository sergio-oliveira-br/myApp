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

//Methods for loading all expenses no filter
//src/main/resources/static/js/modules/expenses/expensesReport/expensesAllDataFilter.js

/**
 * Page: Expense Report
 * Item: Table
 * Method: Load all expenses into the table without filtering
 */
function getAllExpenses() {
    loadFilteredExpenses("/api/v1/expense");
}