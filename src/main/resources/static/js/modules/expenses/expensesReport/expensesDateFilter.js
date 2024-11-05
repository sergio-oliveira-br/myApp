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

//Methods for loading and filtering by data.
//src/main/resources/static/js/modules/expenses/expensesReport/expensesDateFilter.js

/**
 * Page: expense Report
 * Item: Table
 * Method: Filter expenses by date (Month and Year)
 */
function getExpensesByMonth(year, month) {
    let url = "/api/v1/expense/year-month?year=" + encodeURIComponent(year) + "&month=" + encodeURIComponent(month);
    loadFilteredExpenses(url);
}
