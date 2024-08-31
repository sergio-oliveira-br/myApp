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

//This file contain functions related to page redirection.
//src/main/resources/static/js/modules/utilities/navigation.js

/**
 * Function: displayMsgWIP()
 * Info: Display a "Work in Progress" message
 */
function displayMsgWIP() {
    alert("Sorry! Working in progress...");
}

/**
 * Function: goToReportPage()
 * Info: Redirecting the user to the reports page
 */
function goToReportPage() {
    window.location.href = "report.html";
}

/**
 * Function: goToExpenseReportPage()
 * Info: Redirecting the user to the expense reports page
 */
function goToExpenseReportPage() {
    window.location.href = "expensesreport.html";
}

/**
 * Function: goToExpensePage()
 * Info: Redirecting the user to the expense page
 */
function goToExpensePage() {
    window.location.href = "expenses.html";
}
